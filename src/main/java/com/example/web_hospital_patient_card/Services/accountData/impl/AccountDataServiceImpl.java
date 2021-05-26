package com.example.web_hospital_patient_card.Services.accountData.impl;

import com.example.web_hospital_patient_card.Models.entities.AccountDataEntity;
import com.example.web_hospital_patient_card.Repositories.AccountDataRepository;
import com.example.web_hospital_patient_card.Services.accountData.AccountDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountDataServiceImpl implements AccountDataService {

    @Autowired
    private AccountDataRepository accountDataRepository;


    @Override
    public AccountDataEntity getByUserId(long id) {
        return accountDataRepository.findById(id);
    }
}
