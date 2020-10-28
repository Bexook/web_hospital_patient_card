package com.example.web_hospital_patient_card.SecurityConfig.Encoder;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
@Service
public interface PasswordEncoder {

    public BCryptPasswordEncoder getBCryptEncoder();

}
