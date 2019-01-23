package com.phoenix.jobpostings.controllers;

import java.util.List;

import javax.validation.Valid;

import com.phoenix.jobpostings.models.Job;
import com.phoenix.jobpostings.services.JobService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class JobController {
    private final JobService jobService;

    public JobController(JobService jobService) {
        this.jobService = jobService;
    }

    // Start Here
    @GetMapping(value = "")
    public String getDashboard( Model model) {
        List <Job> allJobs = jobService.allJobs();
        model.addAttribute("allJobs", allJobs); 
        return "dashboard.html";
    }


    

}