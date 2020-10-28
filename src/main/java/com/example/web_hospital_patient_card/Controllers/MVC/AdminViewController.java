package com.example.web_hospital_patient_card.Controllers.MVC;

import com.example.web_hospital_patient_card.Models.User;
import com.example.web_hospital_patient_card.Services.RepoService.UserRepoServiceClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin")
public class AdminViewController {

    @Autowired
    private UserRepoServiceClass userRepoServiceClass;

    @GetMapping("/add_new_admin_page")
    public String getAdminAddingPage(){
        return "register_user";
    }

    @GetMapping("/edit_user_page")
    public String getAdminEditUserPage(){
        return "find_to_edit_user_data";
    }

    @GetMapping("/edit_user")
    public String editUserData(Model model, @RequestParam("user_email") String email){
        User user = userRepoServiceClass.getUserByEmail(email);
        String page;
        if(user!=null){
            model.addAttribute("user",user);
            page = "edit_user_data";
        }else{
            page = "find_to_edit_user_data";
            model.addAttribute("user","there are not to such user, try again");
        }
        return page;
    }

}
