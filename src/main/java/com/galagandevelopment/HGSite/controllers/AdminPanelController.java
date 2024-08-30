package com.galagandevelopment.HGSite.controllers;

import com.galagandevelopment.HGSite.models.User;
import com.galagandevelopment.HGSite.services.UserService;
import com.galagandevelopment.HGSite.utils.CustomUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminPanelController {
    @Autowired
    private UserService userService;

    @GetMapping("/admin")
    public String adminPanel(@AuthenticationPrincipal CustomUserDetails userDetails, Model model) {
        User user = userDetails.getUser();
        if (user.getRole().equals("TEACHER")) {
            model.addAttribute("students", user.getStudents());

            return "teacher-dashboard";
        }else if (user.getRole().equals("STUDENT")) {
            model.addAttribute("teacher", user.getTeacher());
            return "student-dashboard";
        }
        return "access-denied";
    }
}
