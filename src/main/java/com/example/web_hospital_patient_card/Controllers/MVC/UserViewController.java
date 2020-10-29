package com.example.web_hospital_patient_card.Controllers.MVC;

import com.example.web_hospital_patient_card.Services.RepoService.UserRepoServiceClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserViewController {

    @Autowired
    private UserRepoServiceClass userRepoServiceClass;

    @GetMapping("/user_data")
    public String getUserDataPage(Model model){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();
        model.addAttribute("user",userRepoServiceClass.getSingleUserEmail(currentPrincipalName));
        return "user_check_page";
    }


}
