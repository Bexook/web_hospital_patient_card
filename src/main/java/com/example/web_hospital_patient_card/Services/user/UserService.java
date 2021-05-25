package com.example.web_hospital_patient_card.Services.user;


import com.example.web_hospital_patient_card.Models.entities.UserEntity;

public interface UserService {

    UserEntity getUserByEmail(String email);
    UserEntity getUserByPhoneNumber(String phoneNumber);

}
