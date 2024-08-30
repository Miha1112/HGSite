package com.galagandevelopment.HGSite.controllers;

import com.galagandevelopment.HGSite.models.User;
import com.galagandevelopment.HGSite.services.UserService;
import com.galagandevelopment.HGSite.utils.CustomUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {
    @Autowired
    private UserService userService;
    @GetMapping("/students")
    public List<User> getStudents(@AuthenticationPrincipal CustomUserDetails userDetails) {
        User teacher = userService.findByUsername(userDetails.getUsername()).get();
        return List.copyOf(teacher.getStudents());
    }
    @PostMapping("/students")
    public User addStudent(@AuthenticationPrincipal CustomUserDetails userDetails, @RequestBody User student) {
        User teacher = userService.findByUsername(userDetails.getUsername()).get();
        userService.addStudent(teacher, student);
        return student;
    }
}
