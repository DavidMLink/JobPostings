package com.phoenix.jobpostings.controllers;

import java.util.List;

import com.phoenix.jobpostings.models.Rating;
import com.phoenix.jobpostings.services.RatingService;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RatingCRUD {
    private final RatingService ratingService;
    public RatingCRUD(RatingService ratingService){
        this.ratingService = ratingService;
    }
    
    // CRUD

        // CREATE
            @RequestMapping(value="/api/ratings", method=RequestMethod.POST)
            public Rating create(@RequestParam(value="stars") String stars) { 
                Rating rating = new Rating( stars ); 
                return ratingService.createRating(rating); 
            } 
        
        // READ 
            // Specific Table 
            @RequestMapping("/api/ratings/{id}") 
            public Rating show(@PathVariable("id") Long id) { 
                Rating rating = ratingService.findRating(id); 
                return rating; 
            } 
            // All Tables 
            @RequestMapping("/api/ratings") 
            public List<Rating> index() { 
                return ratingService.allRatings(); 
            } 
        
        // UPDATE 
            @RequestMapping(value="/api/ratings/{id}", method=RequestMethod.PUT) 
            public Rating update(@PathVariable("id") Long id, @RequestParam(value="stars") String stars) { 
                Rating rating = new Rating(id, stars ); 
                Rating ratingUpdated = ratingService.updateRating(rating); 
                return ratingUpdated; 
            } 
        // DELETE 
            @RequestMapping(value="/api/ratings/{id}", method=RequestMethod.DELETE) 
            public void destroy(@PathVariable("id") Long id) { 
                ratingService.deleteRating(id); 
            } 
    // END OF CRUD 
} 
