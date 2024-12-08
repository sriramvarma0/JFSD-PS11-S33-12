package com.example.touristhomestayplatform.controller;

import com.example.touristhomestayplatform.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public String showLoginForm() {
        return "login"; // Renders login.html
    }

    @PostMapping("/login")
    public ModelAndView loginUser(@RequestParam String username, @RequestParam String password) {
        ModelAndView modelAndView = new ModelAndView();
        if (userService.authenticateUser(username, password)) {
            modelAndView.setViewName("redirect:/home"); // Redirect to home page after login
        } else {
            modelAndView.setViewName("login"); // Stay on login page
            modelAndView.addObject("errorMessage", "Invalid username or password.");
        }
        return modelAndView;
    }
}
