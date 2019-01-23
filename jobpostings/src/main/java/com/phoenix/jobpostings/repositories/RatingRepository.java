package com.phoenix.jobpostings.repositories;

import java.util.List;
import java.util.Optional;

import com.phoenix.jobpostings.models.Rating;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RatingRepository extends CrudRepository<Rating, Long>{

    // CRUD METHODS

        // CREATE

        // END OF CREATE

        // READ
        
        List<Rating> findAll();
        
        // List<Rating> findByDescriptionContaining(String search);
        
        // Long countByTitleContaining(String search);
        
        // END OF READ

        // UPDATE

        // END OF UPDATE

        // DELETE

        // Long deleteByTitleStartingWith(String search);

        // this method deletes a Rating by id
        List<Rating> deleteById(long id);

        // END OF DELETE

    // END OF CRUD METHODS

}