package com.example.web_hospital_patient_card.Services.user.impl;

import com.example.web_hospital_patient_card.Models.entities.UserEntity;
import com.example.web_hospital_patient_card.Services.user.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Override
    public UserEntity getUserByEmail(String email) {
        return null;
    }

    @Override
    public UserEntity getUserByPhoneNumber(String phoneNumber) {
        return null;
    }
}
