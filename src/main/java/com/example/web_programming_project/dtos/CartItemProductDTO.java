package com.example.web_programming_project.dtos;

public class CartItemProductDTO {
    private Integer cartItemId;
    private Integer cartId;
    private Integer productId;
    private String productName;
    private String description;
    private Double price;
    private String image;
    private Integer stock;
    private Integer quantity;

    // Constructor
    public CartItemProductDTO(Integer cartItemId, Integer cartId, Integer productId, String productName,
                              String description, Double price, String image, Integer stock, Integer quantity) {
        this.cartItemId = cartItemId;
        this.cartId = cartId;
        this.productId = productId;
        this.productName = productName;
        this.description = description;
        this.price = price;
        this.image = image;
        this.stock = stock;
        this.quantity = quantity;
    }

    // Getters and Setters
}
