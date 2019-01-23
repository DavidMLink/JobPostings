package com.phoenix.jobpostings.services;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import com.phoenix.jobpostings.models.Rating;
import com.phoenix.jobpostings.repositories.RatingRepository;

@Service
public class RatingService {
    // adding the Rating repository as a dependency
    private final RatingRepository ratingRepository;
    
    public RatingService(RatingRepository ratingRepository) {
        this.ratingRepository = ratingRepository;
    }

    // CRUD METHODS
    
        // CREATE
        public Rating createRating(Rating b) {
            return ratingRepository.save(b);
        }
        // END OF CREATE

        // READ
        public List<Rating> allRatings() {
            return ratingRepository.findAll();
        }

        public Rating findRating(Long id) {
            Optional<Rating> optionalRating = ratingRepository.findById(id);
            if(optionalRating.isPresent()) {
                return optionalRating.get();
            } else {
                return null;
            }
        }
        // END OF READ

        // UPDATE
        public Rating updateRating(Rating b){
            return ratingRepository.save(b);
        }
        // END OF UPDATE

        // DELETE
        public void deleteRating(Long id){
            ratingRepository.deleteById(id);
        }
        // END OF DELETE
        
    // END OF CRUD METHODS
}