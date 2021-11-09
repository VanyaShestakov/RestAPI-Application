package com.ivanshestakov.rest_api.rest.repository;


import com.ivanshestakov.rest_api.rest.entity.Patient;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class PatientDAOImpl implements PatientDAO{

    @Autowired
    private EntityManager entityManager;

    public List<Patient> getAll() {
        Session session = entityManager.unwrap(Session.class);
        return session.createQuery("from Patient ", Patient.class).getResultList();
    }

    public Patient get(int id) {
        return entityManager.unwrap(Session.class).get(Patient.class, id);
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