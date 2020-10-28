package com.example.web_hospital_patient_card.Services.RepoService;

import com.example.web_hospital_patient_card.Models.Pill;
import com.example.web_hospital_patient_card.Repositories.PillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PillRepoServiceClass {

    @Autowired
    private PillRepository pillRepository;


    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public Pill getPillByName(String name){
        return pillRepository.findByName(name);
    }

}
