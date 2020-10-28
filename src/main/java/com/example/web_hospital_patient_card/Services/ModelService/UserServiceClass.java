package com.example.web_hospital_patient_card.Services.ModelService;

import com.example.web_hospital_patient_card.Models.Role;
import com.example.web_hospital_patient_card.Models.Sickness;
import com.example.web_hospital_patient_card.Models.User;
import com.example.web_hospital_patient_card.Services.RepoService.UserRepoServiceClass;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.sql.Date;

@Service
public class UserServiceClass {

    private UserRepoServiceClass userRepoServiceClass;

    public Date getDateFromString(String date){
        String[] dateFormat = date.split("-");
        return Date.valueOf(dateFormat[2]+"-"+dateFormat[1]+"-"+dateFormat[0]);
    }


    public Role setCastStringToRole(String role){
        switch (role){
            case "admin":
                return Role.ADMIN;
            case "doctor":
                return Role.DOCTOR;
            default:
                return Role.USER;
        }
    }


    public void addNewSickness(String email, Sickness s){
        User user = userRepoServiceClass.getUserByEmail(email);
        user.getSicknessList().add(s);
        userRepoServiceClass.updateUser(user);
    }


}
