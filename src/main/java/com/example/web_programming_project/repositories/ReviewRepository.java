package com.example.web_programming_project.repositories;

import com.example.web_programming_project.entities.Review;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review,Integer> {
    @Query(value = "SELECT s FROM Review s")
    public List<Review> getAllReviews();
    @Modifying
    @Transactional
    @Query(value = "DELETE FROM Review WHERE review_id = :id")
    public void deleteReviewsById(Integer id);
    @Modifying
    @Transactional
    @Query(value = "UPDATE Review SET rating=?2 WHERE review_id = ?1")
    public void updateRatingById(Integer id,Integer rating);

    @Query(value="SELECT * FROM Reviews a WHERE a.review_id=?1", nativeQuery=true)
    List<Review> getReviewsById(@Param("id") Integer id);
    @Modifying
    @Transactional
    @Query(
            value =
                    "INSERT INTO Reviews (user_id,product_id,rating,comment) values (?1,?2,?3,?4)",
            nativeQuery = true)
    void addReview(Integer user_id,Integer product_id,Integer rating,String comment);
}
