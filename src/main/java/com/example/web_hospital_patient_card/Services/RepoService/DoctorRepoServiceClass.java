package com.example.web_hospital_patient_card.Services.RepoService;

import com.example.web_hospital_patient_card.Models.Doctor;
import com.example.web_hospital_patient_card.Repositories.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DoctorRepoServiceClass {

    @Autowired
    private DoctorRepository repository;


    public Doctor getDoctorById(long id){
        return repository.getById(id);
    }

}
