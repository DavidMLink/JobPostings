package com.phoenix.jobpostings.services;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import com.phoenix.jobpostings.models.Review;
import com.phoenix.jobpostings.repositories.ReviewRepository;

@Service
public class ReviewService {
    // adding the Review repository as a dependency
    private final ReviewRepository reviewRepository;
    
    public ReviewService(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    // CRUD METHODS
    
        // CREATE
        public Review createReview(Review b) {
            return reviewRepository.save(b);
        }
        // END OF CREATE

        // READ
        public List<Review> allReviews() {
            return reviewRepository.findAll();
        }

        public Review findReview(Long id) {
            Optional<Review> optionalReview = reviewRepository.findById(id);
            if(optionalReview.isPresent()) {
                return optionalReview.get();
            } else {
                return null;
            }
        }
        // END OF READ

        // UPDATE
        public Review updateReview(Review b){
            return reviewRepository.save(b);
        }
        // END OF UPDATE

        // DELETE
        public void deleteReview(Long id){
            reviewRepository.deleteById(id);
        }
        // END OF DELETE
        
    // END OF CRUD METHODS
}