package com.example.web_programming_project.controllers;


import com.example.web_programming_project.entities.Review;
import com.example.web_programming_project.services.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class ReviewController {
    @Autowired
    private ReviewService reviewService;
    @PutMapping("/updatereview")
    public void updateCategory(@RequestBody Review reviews){
        reviewService.updateRatingById(reviews.getReview_id(),reviews.getRating());
    }
    @GetMapping("/getreviews")
    public List<Review> getreviews(){
        return reviewService.getAllReviews();
    }
    @DeleteMapping("/deletereview")
    public void deletereview(@RequestBody Review reviews) {
        reviewService.deleteReviewsById(reviews.getReview_id());
    }
    @GetMapping("/getreview/{id}")
    public List<Review> getReviewById(@PathVariable("id") Integer id){
        return reviewService.getReviewsById(id);
    }
    @PostMapping("/addReview")
    public void postDetails(@RequestBody Review reviews){
        reviewService.addReview(reviews.getUser_id(),reviews.getProduct_id(),reviews.getRating()
                ,reviews.getComment());
    }
}

