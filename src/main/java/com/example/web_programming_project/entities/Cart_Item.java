package com.example.web_programming_project.entities;

import jakarta.persistence.*;

@Table(name = "Cart_Item")
@Entity
public class Cart_Item {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    private Integer cart_item_id;

    @Column(nullable = false)
    private Integer cart_id;
    @Column(nullable = false)
    private Integer product_id;
    @Column(nullable = false)
    private Integer quantity;

    public Integer getCart_item_id() {
        return cart_item_id;
    }
    public void setCart_item_id(Integer cart_item_id) {
        this.cart_item_id = cart_item_id;
    }
    public Integer getCart_id() {
        return cart_id;
    }
    public void setCart_id(Integer cart_id) {
        this.cart_id = cart_id;
    }
    public Integer getProduct_id() {
        return product_id;
    }
    public void setProduct_id(Integer product_id) {
        this.product_id = product_id;
    }
    public Integer getQuantity() {
        return quantity;
    }
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

}