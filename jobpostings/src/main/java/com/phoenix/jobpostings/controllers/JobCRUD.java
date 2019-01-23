package com.phoenix.jobpostings.controllers;

import java.util.List;

import com.phoenix.jobpostings.models.Job;
import com.phoenix.jobpostings.services.JobService;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JobCRUD {
    private final JobService jobService;
    public JobCRUD(JobService jobService){
        this.jobService = jobService;
    }
    
    // CRUD

        // CREATE
            @RequestMapping(value="/api/jobs", method=RequestMethod.POST)
            public Job create(@RequestParam(value="company") String company, @RequestParam(value="title") String title, @RequestParam(value="summary") String summary, @RequestParam(value="salary") Integer salary, @RequestParam(value="location") String location) { 
                Job job = new Job( company, title, summary, salary, location ); 
                return jobService.createJob(job); 
            } 
        
        // READ 
            // Specific Table 
            @RequestMapping("/api/jobs/{id}") 
            public Job show(@PathVariable("id") Long id) { 
                Job job = jobService.findJob(id); 
                return job; 
            } 
            // All Tables 
            @RequestMapping("/api/jobs") 
            public List<Job> index() { 
                return jobService.allJobs(); 
            } 
        
        // UPDATE 
            @RequestMapping(value="/api/jobs/{id}", method=RequestMethod.PUT) 
            public Job update(@PathVariable("id") Long id, @RequestParam(value="company") String company,  @RequestParam(value="title") String title,  @RequestParam(value="summary") String summary,  @RequestParam(value="salary") Integer salary,  @RequestParam(value="location") String location) { 
                Job job = new Job(id, company, title, summary, salary, location ); 
                Job jobUpdated = jobService.updateJob(job); 
                return jobUpdated; 
            } 
        // DELETE 
            @RequestMapping(value="/api/jobs/{id}", method=RequestMethod.DELETE) 
            public void destroy(@PathVariable("id") Long id) { 
                jobService.deleteJob(id); 
            } 
    // END OF CRUD 
} 
