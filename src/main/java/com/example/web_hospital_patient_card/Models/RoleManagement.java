package com.example.web_hospital_patient_card.Models;

import org.springframework.security.core.GrantedAuthority;

public class RoleManagement implements GrantedAuthority {

    private User user;

    public RoleManagement(User user) {
        this.user = user;
    }

    @Override
    public String getAuthority() {
        return user.getRole().name();
    }
}
