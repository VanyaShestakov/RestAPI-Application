package com.ivanshestakov.rest_api.rest.repository;

import com.ivanshestakov.rest_api.rest.entity.Patient;

import java.util.List;
import java.util.Optional;

public interface PatientRepository {

    public List<Patient> getAll();

    public Patient get(int id);

    public void delete(Patient patient);

    public void save(Patient patient);

    public void update(Patient patient);

    public List<Patient> getBySex(String sex);

    public boolean contains(Patient patient);

}
