package com.ivanshestakov.rest_api.rest.service;

import com.ivanshestakov.rest_api.rest.entity.Patient;

import java.util.List;

public interface PatientService {

    public List<Patient> getPatients();

    public Patient getPatient(int id);

    public List<Patient> getPatientsBySex(String sex);

    public void savePatient(Patient patient);

    public void updatePatient(Patient patient);

    public void deletePatientWithId(int id);
}
