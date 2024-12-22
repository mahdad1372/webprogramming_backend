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
@Table(name = "order")
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    @Id
    @Column(name = "order_id")
    private Integer order_id;
    @Column(name = "user_id")
    private Integer user_id;
    @Column(name = "total_amount")
    private Integer total_amount;
    @Column(name = "status")
    private String status;
    @Column(name = "order_date")
    private Timestamp order_date;
    @Column(name = "created_at")
    private Timestamp created_at;
    @Column(name = "updated_at")
    private Timestamp updated_at;

    public Integer getOrder_id() {
        return order_id;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public Integer getTotal_amount() {
        return total_amount;
    }

    public String getStatus() {
        return status;
    }
}