package com.example.web_hospital_patient_card.Models.roles;

import com.example.web_hospital_patient_card.Models.dto.UserDTO;
import org.springframework.security.core.GrantedAuthority;

public class RoleManagement implements GrantedAuthority {

    private UserDTO user;

    public RoleManagement(UserDTO user) {
        this.user = user;
    }

    @Override
    public String getAuthority() {
        return user.getRole().name();
    }
}
