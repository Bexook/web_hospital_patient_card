package com.example.web_hospital_patient_card.SecurityConfig.AppSecurityConfig;


import com.example.web_hospital_patient_card.Models.entities.AccountDataEntity;
import com.example.web_hospital_patient_card.Models.entities.UserEntity;
import com.example.web_hospital_patient_card.Services.accountData.AccountDataService;
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
    private AccountDataService accountDataService;

    @Autowired
    public AppUserDetailsService(UserService userService, UserEntityToUserDTOMapper mapper) {
        this.userService = userService;
        this.mapper = mapper;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        UserEntity user = getUserByEmail(s);
        return new AppUserDetails(mapper.userEntityToUserAccountEntityDTO(user,accountDataService.getByUserId(user.getId())));
    }


    private UserEntity getUserByEmail(String email){
        return userService.getUserByEmail(email);
    }

}
