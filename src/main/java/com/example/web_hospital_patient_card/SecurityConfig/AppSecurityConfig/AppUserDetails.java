package com.example.web_hospital_patient_card.SecurityConfig.AppSecurityConfig;

import com.example.web_hospital_patient_card.Models.dto.UserAccountDataDTO;
import com.example.web_hospital_patient_card.Models.dto.UserDTO;
import com.example.web_hospital_patient_card.Models.entities.UserEntity;
import com.example.web_hospital_patient_card.Models.roles.RoleManagement;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;


public class AppUserDetails implements UserDetails {


    private UserAccountDataDTO user;

    public AppUserDetails(UserAccountDataDTO user) {
        this.user = user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        RoleManagement roleManagement = new RoleManagement(user);
        return List.of(new SimpleGrantedAuthority(roleManagement.getAuthority()));
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getEmail();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return !user.isPasswordExpired();
    }

    @Override
    public boolean isEnabled() {
        return user.isActive();
    }
}
