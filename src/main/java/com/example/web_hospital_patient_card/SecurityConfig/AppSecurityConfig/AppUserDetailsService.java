package com.example.web_hospital_patient_card.SecurityConfig.AppSecurityConfig;

import com.example.web_hospital_patient_card.Models.User;
import com.example.web_hospital_patient_card.Services.RepoService.UserRepoServiceClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

@Repository
public class AppUserDetailsService implements UserDetailsService {


    @Autowired
    private UserRepoServiceClass userRepoServiceClass;


    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return new AppUserDetails(getUserByEmail(s));
    }


    private User getUserByEmail(String s){
        return userRepoServiceClass.getSingleUserEmail(s);
    }

}
