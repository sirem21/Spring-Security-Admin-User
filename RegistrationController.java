package com.example.demo.controller;

import com.example.demo.dto.UserDto;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriBuilder;

import java.security.Principal;
import java.util.List;

@Controller
public class RegistrationController {
    @Autowired
    UserDetailsService userDetailsService;
    @Autowired
    private UserService userService;
    @GetMapping("/registration")
    public String logPage(@ModelAttribute ("user") UserDto userDto, Model model){
        return "registrationPage";
    }
    @PostMapping("/registration")
    public String saveUserPage(@ModelAttribute ("user") UserDto userDto, Model model){
        userService.save(userDto);
        model.addAttribute("message","Registrated successfully!");
        return "registrationPage";
    }

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @GetMapping("/admin-page")
    public String adminPage(Model model, Principal principal){
        UserDetails userDetails = userDetailsService.loadUserByUsername(principal.getName());
        model.addAttribute("admin",userDetails);
        return "admin";
    }

    @GetMapping("/user-page")
    public String userPage(Model model, Principal principal){
        UserDetails userDetails = userDetailsService.loadUserByUsername(principal.getName());
        model.addAttribute("user",userDetails);
        return "user";
    }

    @GetMapping("/all/users")
    @ResponseBody
    public List<UserDto> getUsers() {
        return userService.findAll(); // Make sure `findAll` is implemented in your service
    }
}
