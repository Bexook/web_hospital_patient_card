package com.example.web_hospital_patient_card.Controllers.ServiceControlles;

import com.example.web_hospital_patient_card.Models.entities.MedicineEntity;
import com.example.web_hospital_patient_card.Models.entities.Sickness;
import com.example.web_hospital_patient_card.Models.entities.User;
import com.example.web_hospital_patient_card.SecurityConfig.Encoder.PasswordEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.text.ParseException;
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
    public ModelAndView insertUser(@RequestParam(value = "name") String name,
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
            System.out.println("s");
        }
        user.setName(name);
        if (surname == null) {
            System.out.println("s");
        }
        user.setSurname(surname);

        if (email == null) {
            System.out.println("s");
        }

        user.setEmail(email);

        if (role == null) {
            System.out.println("s");
        }
        user.setRole(userServiceClass.setCastStringToRole(role));

        if (password == null) {
            System.out.println("s");
        }
        user.setPassword(passwordEncoder.getBCryptEncoder().encode(password));

        if (recovery_period == 0) {
            System.out.println("s");
        }
        user.setRecoveryPeriod(recovery_period);
        if (birthDate == null) {
            System.out.println("s");
        }
        user.setBirthDate(userServiceClass.getDateFromString(birthDate));
        if (lastAttendanceDate == null) {
            System.out.println("s");
        }
        user.setLastAttendanceDate(userServiceClass.getDateFromString(lastAttendanceDate));

        if (pill_name == null) {
            System.out.println("s");
        }

        if(pillRepoServiceClass.getPillByName(pill_name)==null){
            MedicineEntity s =new MedicineEntity();
            s.setName(pill_name);
            user.setPillList(List.of(s));
        }else {
            user.setPillList(List.of(pillRepoServiceClass.getPillByName(pill_name)));
        }


        if (sicknessName == null) {
            System.out.println("s");
        }

        if(sicknessRepoServiceClass.getSicknessByName(sicknessName)==null){
            Sickness sickness =new Sickness();
            sickness.setName(sicknessName);
            user.setSicknessList(List.of(sickness));
        }else{
            user.setSicknessList(List.of(sicknessRepoServiceClass.getSicknessByName(sicknessName)));
        }


        if (doctor_id == 0) {
            System.out.println("s");
        }

        user.setDoctor(doctorRepoServiceClass.getDoctorById(doctor_id));



        userRepoServiceClass.addNewUser(user);
        return new ModelAndView("redirect:/admin/show_all","users",userRepoServiceClass.getAllUsers());
    }


    @PostMapping("/edit_user_data_submit")
    public ModelAndView editUser(Model model,@RequestParam(value = "user_id",defaultValue = "0") long id,
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
            MedicineEntity s = new MedicineEntity();
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
        return new ModelAndView("redirect:/admin/show_all","users",userRepoServiceClass.getAllUsers());
    }


    @PostMapping("/delete")
    @ResponseBody
    public void delete(@RequestParam("user_email") String email){
        userRepoServiceClass.deleteUser(email);
    }
}
