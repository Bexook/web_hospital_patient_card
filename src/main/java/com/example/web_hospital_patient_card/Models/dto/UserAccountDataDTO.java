package com.example.web_hospital_patient_card.Models.dto;

import com.example.web_hospital_patient_card.Models.roles.Role;
import lombok.Data;
import java.time.LocalDate;

@Data
public class UserAccountDataDTO {

    private long id;
    private String email;
    private String password;
    private Role role;
    private boolean isActive;
    private boolean isPasswordExpired;
    private LocalDate creationDate;
    private LocalDate lastUpdateDate;

}
