package com.example.web_hospital_patient_card.Models.dto;

import com.example.web_hospital_patient_card.Models.roles.Role;
import lombok.Data;
import lombok.extern.apachecommons.CommonsLog;
import org.springframework.stereotype.Component;

@Data
public class UserDTO {

    private long id;
    private String email;
    private String password;
    private String phoneNumber;
    private Role role;


}
