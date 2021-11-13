package com.ivanshestakov.rest_api.rest.repository.impl;


import com.ivanshestakov.rest_api.rest.entity.Patient;
import com.ivanshestakov.rest_api.rest.exceptions.NoSuchPatientException;
import com.ivanshestakov.rest_api.rest.repository.PatientRepository;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

@Repository
public class PatientDAOImpl implements PatientRepository {

    @Autowired
    private EntityManager entityManager;

    public List<Patient> getAll() {
        Session session = entityManager.unwrap(Session.class);
        return session.createQuery("from Patient ", Patient.class).getResultList();
    }

    public Patient get(int id) {
        Session session = entityManager.unwrap(Session.class);
        Optional<Patient> optionalPatient = Optional.ofNullable(session.get(Patient.class, id));
        return optionalPatient.orElseThrow(() -> {
            throw new NoSuchPatientException("No such patient with id=" + id);
        });
    }

    public List<Patient> getBySex(String sex) {
        Session session = entityManager.unwrap(Session.class);
        return session.createQuery("from Patient where sex = " + sex, Patient.class).getResultList();
    }

    public void delete(Patient patient) {
        entityManager.unwrap(Session.class).delete(patient);
    }

    public void save(Patient patient) {
        entityManager.unwrap(Session.class).persist(patient);
    }

    public void saveAll(List<Patient> patients) {
        Session session = entityManager.unwrap(Session.class);
        patients.forEach(session::persist);
    }

    public void update(Patient patient) {
        entityManager.unwrap(Session.class).update(patient);
    }

    public boolean contains(Patient patient) {
        return entityManager.unwrap(Session.class).contains(patient);
    }
}
