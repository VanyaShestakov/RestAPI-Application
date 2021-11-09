package com.ivanshestakov.rest_api.rest.service;

import com.ivanshestakov.rest_api.rest.repository.PatientDAO;
import com.ivanshestakov.rest_api.rest.entity.Patient;
import com.ivanshestakov.rest_api.rest.exceptions.NoSuchPatientException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class PatientServiceImpl implements PatientService{

    @Autowired
    private PatientDAO patientDAO;

    @Override
    @Transactional
    public List<Patient> getPatients() {
        return patientDAO.getAll();
    }

    @Override
    @Transactional
    public Patient getPatient(int id) {
        return patientDAO.get(id);
    }

    @Override
    @Transactional
    public List<Patient> getPatientsBySex(String sex) {
        return patientDAO.getBySex(sex);
    }

    @Override
    @Transactional
    public void savePatient(Patient patient) {
        patientDAO.save(patient);
    }

    @Override
    @Transactional
    public void updatePatient(Patient patient) {
        patientDAO.update(patient);
    }

    @Override
    @Transactional
    public void deletePatientWithId(int id) {
        Patient patient = patientDAO.get(id);
        patientDAO.delete(patient);
    }

}
