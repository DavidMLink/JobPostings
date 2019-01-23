package com.phoenix.jobpostings.repositories;

import java.util.List;
import java.util.Optional;

import com.phoenix.jobpostings.models.Job;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobRepository extends CrudRepository<Job, Long>{

    // CRUD METHODS

        // CREATE

        // END OF CREATE

        // READ
        
        List<Job> findAll();
        
        // List<Job> findByDescriptionContaining(String search);
        
        // Long countByTitleContaining(String search);
        
        // END OF READ

        // UPDATE

        // END OF UPDATE

        // DELETE

        // Long deleteByTitleStartingWith(String search);

        // this method deletes a Job by id
        List<Job> deleteById(long id);

        // END OF DELETE

    // END OF CRUD METHODS

}