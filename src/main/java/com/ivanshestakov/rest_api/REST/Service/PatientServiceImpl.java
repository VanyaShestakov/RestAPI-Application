package com.ivanshestakov.rest_api.REST.Service;

import com.ivanshestakov.rest_api.REST.DAO.PatientDAO;
import com.ivanshestakov.rest_api.REST.Entity.Patient;
import com.ivanshestakov.rest_api.REST.Exceptions.NoSuchPatientException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

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
        Patient removablePatient = patientDAO.get(id);
        if (!patientDAO.contains(removablePatient)) {
            throw new NoSuchPatientException("Patient with id=" + id + " not found");
        }
        patientDAO.delete(removablePatient);
    }

}
