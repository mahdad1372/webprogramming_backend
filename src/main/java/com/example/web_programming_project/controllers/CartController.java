package com.example.web_programming_project.controllers;

import com.example.web_programming_project.entities.Cart;
import com.example.web_programming_project.services.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RequestMapping("/cart")
@RestController
public class CartController {
    @Autowired
    private CartService cartService;
    @PutMapping("/update")
    public void updateCartByCart_id(@RequestBody Cart cart){
        cartService.updateCartByCart_id(cart.getCart_id(),cart.getUser_id());
    }
    @GetMapping("/getcart")
    public List<Cart> getAllCarts(){
        return cartService.getAllCarts();
    }
    @DeleteMapping("/delete")
    public void deleteCartByCart_id(@RequestBody Cart cart) {
        cartService.deleteCartByCart_id(cart.getCart_id());
    }
    @GetMapping("/getcart/{id}")
    public List<Cart> getCartByCart_id(@PathVariable("id") Integer id){
        return cartService.getCartByCart_id(id);
    }
    @GetMapping("/getcartbyuserid/{id}")
    public List<Cart> getCartByUser_id(@PathVariable("id") Integer id){
        return cartService.getCartByUser_id(id);
    }
    @PostMapping("/addcart")
    public void addCart(@RequestBody Cart cart){
        cartService.addCart(cart.getUser_id());
    }
}
