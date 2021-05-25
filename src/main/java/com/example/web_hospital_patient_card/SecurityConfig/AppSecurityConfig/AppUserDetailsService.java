package com.example.web_hospital_patient_card.SecurityConfig.AppSecurityConfig;


import com.example.web_hospital_patient_card.Models.entities.UserEntity;
import com.example.web_hospital_patient_card.Services.user.UserService;
import com.example.web_hospital_patient_card.mapper.UserEntityToUserDTOMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

@Repository
public class AppUserDetailsService implements UserDetailsService {


    private UserService userService;
    private UserEntityToUserDTOMapper mapper;

    @Autowired
    public AppUserDetailsService(UserService userService, UserEntityToUserDTOMapper mapper) {
        this.userService = userService;
        this.mapper = mapper;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return new AppUserDetails(mapper.userEntityToUserDTO(getUserByEmail(s)));
    }


    private UserEntity getUserByEmail(String email){
        return userService.getUserByEmail(email);
    }

}
