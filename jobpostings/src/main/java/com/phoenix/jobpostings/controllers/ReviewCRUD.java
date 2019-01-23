package com.phoenix.jobpostings.controllers;

import java.util.List;

import com.phoenix.jobpostings.models.Review;
import com.phoenix.jobpostings.services.ReviewService;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReviewCRUD {
    private final ReviewService reviewService;
    public ReviewCRUD(ReviewService reviewService){
        this.reviewService = reviewService;
    }
    
    // CRUD

        // CREATE
            @RequestMapping(value="/api/reviews", method=RequestMethod.POST)
            public Review create(@RequestParam(value="comment") String comment) { 
                Review review = new Review( comment ); 
                return reviewService.createReview(review); 
            } 
        
        // READ 
            // Specific Table 
            @RequestMapping("/api/reviews/{id}") 
            public Review show(@PathVariable("id") Long id) { 
                Review review = reviewService.findReview(id); 
                return review; 
            } 
            // All Tables 
            @RequestMapping("/api/reviews") 
            public List<Review> index() { 
                return reviewService.allReviews(); 
            } 
        
        // UPDATE 
            @RequestMapping(value="/api/reviews/{id}", method=RequestMethod.PUT) 
            public Review update(@PathVariable("id") Long id, @RequestParam(value="comment") String comment) { 
                Review review = new Review(id, comment ); 
                Review reviewUpdated = reviewService.updateReview(review); 
                return reviewUpdated; 
            } 
        // DELETE 
            @RequestMapping(value="/api/reviews/{id}", method=RequestMethod.DELETE) 
            public void destroy(@PathVariable("id") Long id) { 
                reviewService.deleteReview(id); 
            } 
    // END OF CRUD 
} 
