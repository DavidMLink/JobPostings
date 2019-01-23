package com.phoenix.jobpostings.repositories;

import java.util.List;
import java.util.Optional;

import com.phoenix.jobpostings.models.Review;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepository extends CrudRepository<Review, Long>{

    // CRUD METHODS

        // CREATE

        // END OF CREATE

        // READ
        
        List<Review> findAll();
        
        // List<Review> findByDescriptionContaining(String search);
        
        // Long countByTitleContaining(String search);
        
        // END OF READ

        // UPDATE

        // END OF UPDATE

        // DELETE

        // Long deleteByTitleStartingWith(String search);

        // this method deletes a Review by id
        List<Review> deleteById(long id);

        // END OF DELETE

    // END OF CRUD METHODS

}