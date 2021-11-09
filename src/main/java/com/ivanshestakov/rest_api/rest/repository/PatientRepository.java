package com.ivanshestakov.rest_api.rest.repository;

import com.ivanshestakov.rest_api.rest.entity.Patient;
import com.ivanshestakov.rest_api.rest.entity.Sex;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Integer> {

    public List<Patient> getНемедленноPatientsBySex(Sex sex);


    public Patient getPatientByAge(int age);


    //public void

}
