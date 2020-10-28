package com.example.web_hospital_patient_card.Services.RepoService;

import com.example.web_hospital_patient_card.Models.Sickness;
import com.example.web_hospital_patient_card.Repositories.SicknessRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SicknessRepoServiceClass {

    @Autowired
    private SicknessRepository sicknessRepository;


    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public Sickness getSicknessById(long id){
        return sicknessRepository.getById(id);
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public Sickness getSicknessByName(String name){
        return sicknessRepository.findByName(name);
    }

}
