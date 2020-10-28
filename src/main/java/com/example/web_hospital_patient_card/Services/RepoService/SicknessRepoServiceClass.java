package com.example.web_hospital_patient_card.Services.RepoService;

import com.example.web_hospital_patient_card.Models.Sickness;
import com.example.web_hospital_patient_card.Repositories.SicknessRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SicknessRepoServiceClass {

    @Autowired
    private SicknessRepository sicknessRepository;


    public Sickness getSicknessById(long id){
        return sicknessRepository.getById(id);
    }

}
