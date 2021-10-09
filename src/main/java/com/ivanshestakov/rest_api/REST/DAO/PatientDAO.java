package com.ivanshestakov.rest_api.REST.DAO;

import com.ivanshestakov.rest_api.REST.Entity.Patient;
import org.hibernate.Session;

import java.util.List;

public interface PatientDAO {

    public List<Patient> getAll();

    public Patient get(int id);

    public void delete(Patient patient);

    public void deleteWithId(int id);

    public void save(Patient patient);

    public void update(Patient patient);

    public List<Patient> getBySex(String sex);


}
