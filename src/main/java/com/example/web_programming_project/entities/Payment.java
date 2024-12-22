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
@Table(name = "payment")
@NoArgsConstructor
@AllArgsConstructor
public class Payment {
    @Id
    @Column(name = "payment_id")
    private Integer payment_id;
    @Column(name = "order_id")
    private Integer order_id;
    @Column(name = "amount")
    private Integer amount;
    @Column(name = "payment_method")
    private String payment_method;
    @Column(name = "payment_status")
    private String payment_status;
    @Column(name = "payment_date")
    private Timestamp payment_date;

}
