package com.galagandevelopment.HGSite.controllers;

import com.galagandevelopment.HGSite.models.User;
import com.galagandevelopment.HGSite.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class AutentificationsController {
    private final UserService userService;

    @GetMapping("/login")
    public String login(){
        return "login";
    }
    @GetMapping("/registration")
    public String registration(){
        return "registration";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute("user") User user){

        return "redirect:/admin";
    }
    @GetMapping("/admin")
    public String admin(){
        return "admin";
    }
    @PostMapping("/registration")
    public String createUser(User user){
        try{
            if(userService.createUser(user) != null){
                return ("redirect:/login");
            }else{
                return ("redirect:/registration");
            }
        }catch(Exception ex){
            return ("redirect:/registration");
        }
    }
}
