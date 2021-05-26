package com.example.web_hospital_patient_card.Services.accountData;


import com.example.web_hospital_patient_card.Models.entities.AccountDataEntity;

public interface AccountDataService {

    AccountDataEntity getByUserId(long id);

}
