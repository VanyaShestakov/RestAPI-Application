package com.ivanshestakov.rest_api.rest.controller;

import com.ivanshestakov.rest_api.rest.entity.Patient;
import com.ivanshestakov.rest_api.rest.entity.Sex;
import com.ivanshestakov.rest_api.rest.exceptions.IncorrectJSONException;
import com.ivanshestakov.rest_api.rest.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class PatientController {

    @Autowired
    private PatientService patientService;

    @GetMapping({"/patients"})
    public List<Patient> getPatients() {
        return patientService.getPatients();
    }

    @PostMapping("/patients")
    public void postPatient(@Valid @RequestBody Patient patient, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new IncorrectJSONException("JSON object is not valid");
        }
        patientService.savePatient(patient);
    }

    @PutMapping("/patients")
    public void putPatient(@Valid @RequestBody Patient patient, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new IncorrectJSONException("JSON object is not valid");
        }
        patientService.updatePatient(patient);
    }

    @DeleteMapping("/patients/id={id}")
    public void deletePatient(@PathVariable int id) {
        patientService.deletePatientWithId(id);
    }

    @GetMapping("/patients/id={id}")
    public Patient getPatientById(@PathVariable int id) {
        return patientService.getPatient(id);
    }


    @GetMapping("/patients/sex={sex}")
    public List<Patient> getPatientsBySex(@PathVariable Sex sex) {
        return patientService.getPatientsBySex(sex.name());
    }
}
