package com.example.web_hospital_patient_card.Controllers.ServiceControlles;

import com.example.web_hospital_patient_card.Models.Doctor;
import com.example.web_hospital_patient_card.Models.Pill;
import com.example.web_hospital_patient_card.Models.Sickness;
import com.example.web_hospital_patient_card.Models.User;
import com.example.web_hospital_patient_card.SecurityConfig.Encoder.PasswordEncoder;
import com.example.web_hospital_patient_card.Services.ModelService.SicknessServiceClass;
import com.example.web_hospital_patient_card.Services.ModelService.UserServiceClass;
import com.example.web_hospital_patient_card.Services.RepoService.DoctorRepoServiceClass;
import com.example.web_hospital_patient_card.Services.RepoService.PillRepoServiceClass;
import com.example.web_hospital_patient_card.Services.RepoService.SicknessRepoServiceClass;
import com.example.web_hospital_patient_card.Services.RepoService.UserRepoServiceClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.annotation.WebInitParam;
import java.text.ParseException;
import java.util.Collections;
import java.util.List;

@Controller
@RequestMapping("/admin_service")
public class AdminServiceController {


    @Autowired
    @Qualifier("BCryptEncoder")
    private PasswordEncoder passwordEncoder;

    @Autowired
    private SicknessRepoServiceClass sicknessRepoServiceClass;

    @Autowired
    private UserServiceClass userServiceClass;

    @Autowired
    private UserRepoServiceClass userRepoServiceClass;

    @Autowired
    private DoctorRepoServiceClass doctorRepoServiceClass;

    @Autowired
    private PillRepoServiceClass pillRepoServiceClass;


    @PostMapping("/addNewAdmin")
    @ResponseBody
    public String insertUser(@RequestParam(value = "name") String name,
                             @RequestParam(value = "surname") String surname,
                             @RequestParam(value = "password") String password,
                             @RequestParam(value = "birth_date") String birthDate,
                             @RequestParam(value = "role") String role,
                             @RequestParam(value = "email") String email,
                             @RequestParam(value = "sickness_name") String sicknessName,
                             @RequestParam(value = "pill_name") String pill_name,
                             @RequestParam(value = "doctor_id",defaultValue = "0") long doctor_id,
                             @RequestParam(value = "recovery_period",defaultValue = "0") int recovery_period,
                             @RequestParam(value = "last_attendance_date") String lastAttendanceDate) throws ParseException {
        System.out.println(name + "\n");

        User user = new User();
        if (name == null) {
            return "setNamePlease";
        }
        user.setName(name);
        if (surname == null) {
            return "setSurNamePlease";
        }
        user.setSurname(surname);

        if (email == null) {
            return "setEmailPlease";
        }

        user.setEmail(email);

        if (role == null) {
            return "setRolePlease";
        }
        user.setRole(userServiceClass.setCastStringToRole(role));

        if (password == null) {
            return "setPasswordPlease";
        }
        user.setPassword(passwordEncoder.getBCryptEncoder().encode(password));

        if (recovery_period == 0) {
            return "setRecoveryPeriodPlease";
        }
        user.setRecoveryPeriod(recovery_period);
        if (birthDate == null) {
            return "setDateOfBirthPlease";
        }
        user.setBirthDate(userServiceClass.getDateFromString(birthDate));
        if (lastAttendanceDate == null) {
            return "setLastAttendanceDate";
        }
        user.setLastAttendanceDate(userServiceClass.getDateFromString(lastAttendanceDate));

        if (pill_name == null) {
            return "setPillIdPlease";
        }

        if(pillRepoServiceClass.getPillByName(pill_name)==null){
            Pill s =new Pill();
            s.setName(pill_name);
            user.setPillList(List.of(s));
        }else {
            user.setPillList(List.of(pillRepoServiceClass.getPillByName(pill_name)));
        }


        if (sicknessName == null) {
            return "setSicknessIdPlease";
        }

        if(sicknessRepoServiceClass.getSicknessByName(sicknessName)==null){
            Sickness sickness =new Sickness();
            sickness.setName(sicknessName);
            user.setSicknessList(List.of(sickness));
        }else{
            user.setSicknessList(List.of(sicknessRepoServiceClass.getSicknessByName(sicknessName)));
        }


        if (doctor_id == 0) {
            return "setDoctorIDPlease";
        }

        user.setDoctor(doctorRepoServiceClass.getDoctorById(doctor_id));



        userRepoServiceClass.addNewUser(user);
        return user.toString();
    }


    @PostMapping("/edit_user_data_submit")
    @ResponseBody
    public String editUser(@RequestParam(value = "user_id",defaultValue = "0") long id,
                            @RequestParam(value = "name",defaultValue = "null") String name,
                             @RequestParam(value = "surname",defaultValue = "null") String surname,
                             @RequestParam(value = "birth_date",defaultValue = "null") String birthDate,
                             @RequestParam(value = "email",defaultValue = "null") String email,
                             @RequestParam(value = "sickness_name",defaultValue = "null") String sicknessName,
                             @RequestParam(value = "pill_name",defaultValue = "null") String pill_name,
                             @RequestParam(value = "doctor_id",defaultValue = "0") long doctor_id,
                             @RequestParam(value = "recovery_period",defaultValue = "0") int recovery_period,
                             @RequestParam(value = "last_attendance_date",defaultValue = "null") String lastAttendanceDate) throws ParseException {

        User user = userRepoServiceClass.getUserById(id);
        System.out.println(user.toString());
        if (!name.equals("null")) {
            user.setName(name);
        }

        if (!surname.equals("null")) {
            user.setSurname(surname);
        }

        if (!email.equals("null")) {
            user.setEmail(email);
        }

        if (recovery_period != 0) {
            user.setRecoveryPeriod(recovery_period);
        }

        if (!birthDate.equals("null")) {
            user.setBirthDate(userServiceClass.getDateFromString(birthDate));
        }

        if (!lastAttendanceDate.equals("null")) {
            user.setLastAttendanceDate(userServiceClass.getDateFromString(lastAttendanceDate));
        }


        if (!pill_name.equals("null")) {
            Pill s = new Pill();
            s.setName(pill_name);
            user.getPillList().add(s);
        }





        if (!sicknessName.equals("null")) {
            Sickness sickness = new Sickness();
            sickness.setName(sicknessName);
            user.getSicknessList().add(sickness);
        }



        if (doctor_id != 0) {
            user.setDoctor(doctorRepoServiceClass.getDoctorById(doctor_id));
        }


        userRepoServiceClass.updateUser(user);
        return user.toString();
    }


}
