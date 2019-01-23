package com.phoenix.jobpostings.controllers;

import java.util.List;

import javax.validation.Valid;

import com.phoenix.jobpostings.models.User;
import com.phoenix.jobpostings.services.UserService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    // Start Here
    /* This should contain only login and registration... */
    @GetMapping(value = "")
    public String getDashboard() {
        return "index.html";
    }
}