package com.example.web_hospital_patient_card.Controllers.MVC;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/*")
public class LoginController {

    @GetMapping("getLoginPage")
    public String getLoginPage(){
        return "login";
    }

}
