package com.ivanshestakov.rest_api.REST.Controller;

import com.ivanshestakov.rest_api.REST.Entity.Patient;
import com.ivanshestakov.rest_api.REST.Service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MainController {

    @Autowired
    private PatientService patientService;

    @GetMapping("/patients")
    public List<Patient> getAllPatients() {
        return patientService.getPatients();
    }

    @PostMapping("/patients")
    public void addPatient(@RequestBody Patient patient) {
        System.out.println(patient);
        patientService.savePatient(patient);
    }

    @GetMapping("/patients/id={id}")
    public Patient getPatientById(@PathVariable int id) {
        return patientService.getPatient(id);
    }


    @GetMapping("/patients/sex={sex}")
    public List<Patient> getPatientsBySex(@PathVariable String sex) {
        return patientService.getPatientsBySex(sex);
    }

}
