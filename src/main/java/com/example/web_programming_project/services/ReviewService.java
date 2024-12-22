package com.example.web_programming_project.services;


import com.example.web_programming_project.entities.Review;
import com.example.web_programming_project.repositories.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ReviewService {
    @Autowired
    private ReviewRepository reviewRepository;
    public List<Review> getAllReviews(){
        return reviewRepository.getAllReviews();
    }
    public List<Review> getReviewsById(Integer id){
        return reviewRepository.getReviewsById(id);
    }
    public void deleteReviewsById(Integer id){
        reviewRepository.deleteReviewsById(id);
    }
    public void updateRatingById(Integer id,Integer Rating){
        reviewRepository.updateRatingById(id,Rating);
    }

    public void addReview(Integer user_id,Integer product_id,Integer rating,String comment){
        reviewRepository.addReview(user_id,product_id,rating,comment);
    }
}

