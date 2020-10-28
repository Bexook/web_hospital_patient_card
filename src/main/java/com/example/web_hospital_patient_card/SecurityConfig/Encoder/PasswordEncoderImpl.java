package com.example.web_hospital_patient_card.SecurityConfig.Encoder;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component("BCryptEncoder")
public class PasswordEncoderImpl implements PasswordEncoder {


    @Override
    public BCryptPasswordEncoder getBCryptEncoder() {
        return  new BCryptPasswordEncoder(10);
    }
}
