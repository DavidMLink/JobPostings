package com.phoenix.jobpostings.controllers;

import java.util.List;

import javax.validation.Valid;

import com.phoenix.jobpostings.models.User;
import com.phoenix.jobpostings.services.UserService;
import com.phoenix.jobpostings.validators.UserValidator;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserController {
    private final UserService userService;
    private final UserValidator userValidator;

    public UserController(UserService userService, UserValidator userValidator) {
        this.userService = userService;
        this.userValidator = userValidator;
    }

    // Start Here
    /* This should contain only login and registration... */
    @GetMapping("")
    public String getDashboard(Model model) {
        model.addAttribute("userObject", new User());
        return "index.html";
    }

    @PostMapping("/register")
    public String registerUser(@Valid @ModelAttribute("userObject") User user, BindingResult results, Model model) {
        userValidator.validate(user, results);
        if (results.hasErrors()) {
            return "index.html";
        } else {
            return "redirect:/dashboard";
        }
    }
}