package com.phoenix.jobpostings.services;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import com.phoenix.jobpostings.models.Job;
import com.phoenix.jobpostings.repositories.JobRepository;

@Service
public class JobService {
    // adding the Job repository as a dependency
    private final JobRepository jobRepository;
    
    public JobService(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    // CRUD METHODS
    
        // CREATE
        public Job createJob(Job b) {
            return jobRepository.save(b);
        }
        // END OF CREATE

        // READ
        public List<Job> allJobs() {
            return jobRepository.findAll();
        }

        public Job findJob(Long id) {
            Optional<Job> optionalJob = jobRepository.findById(id);
            if(optionalJob.isPresent()) {
                return optionalJob.get();
            } else {
                return null;
            }
        }
        // END OF READ

        // UPDATE
        public Job updateJob(Job b){
            return jobRepository.save(b);
        }
        // END OF UPDATE

        // DELETE
        public void deleteJob(Long id){
            jobRepository.deleteById(id);
        }
        // END OF DELETE
        
    // END OF CRUD METHODS
}