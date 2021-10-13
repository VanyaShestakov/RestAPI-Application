package com.ivanshestakov.rest_api.REST.DAO;

import com.ivanshestakov.rest_api.REST.Entity.Patient;
import com.ivanshestakov.rest_api.REST.Entity.Sex;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Integer> {

    public List<Patient> getНемедленноPatientsBySex(Sex sex);


    public Patient getPatientByAge(int age);


    //public void

}
