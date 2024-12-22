package com.example.web_programming_project.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Entity
@Data
@Table(name = "review")
@NoArgsConstructor
@AllArgsConstructor
public class Review {
    @Id
    @Column(name = "review_id")
    private int review_id;
    @Column(name = "user_id")
    private int user_id;
    @Column(name = "product_id")
    private int product_id;
    @Column(name = "rating")
    private int rating;
    @Column(name = "comment")
    private String comment;
    @Column(name = "created_at")
    private Timestamp created_at;
    @Column(name = "updated_at")
    private Timestamp updated_at;

    public int getProduct_id() {
        return product_id;
    }

    public int getReview_id() {
        return review_id;
    }

    public int getRating() {
        return rating;
    }

    public int getUser_id() {
        return user_id;
    }

    public String getComment() {
        return comment;
    }

    public Timestamp getCreated_at() {
        return created_at;
    }

    public Timestamp getUpdated_at() {
        return updated_at;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }
    public void setComment(String comment) {
        this.comment = comment;
    }
    public void setCreated_at(Timestamp created_at) {
        this.created_at = created_at;
    }
    public void setUpdated_at(Timestamp updated_at) {
        this.updated_at = updated_at;
    }

}

