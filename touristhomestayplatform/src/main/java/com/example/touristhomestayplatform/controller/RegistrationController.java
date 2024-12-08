package com.example.touristhomestayplatform.controller;

import com.example.touristhomestayplatform.model.User;
import com.example.touristhomestayplatform.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RegistrationController {

    @Autowired
    private UserService userService;

    @GetMapping("/register")
    public String showRegistrationForm() {
        return "register"; // Renders register.html
    }

    @PostMapping("/register")
    public ModelAndView registerUser(@ModelAttribute User user) {
        ModelAndView modelAndView = new ModelAndView();
        try {
            userService.registerUser(user);
            modelAndView.setViewName("redirect:/login"); // Redirect to login page
        } catch (IllegalArgumentException e) {
            modelAndView.setViewName("register"); // Stay on register page
            modelAndView.addObject("errorMessage", e.getMessage());
        }
        return modelAndView;
    }
}
