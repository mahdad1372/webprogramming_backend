package com.example.web_programming_project.services;

import com.example.web_programming_project.entities.Cart;
import com.example.web_programming_project.repositories.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CartService {
    @Autowired
    private CartRepository cartRepository;
    public List<Cart> getAllCarts(){
        return cartRepository.getAllCarts();
    }
    public List<Cart> getCartByCart_id(Integer id){
        return cartRepository.getCartByCart_id(id);
    }
    public List<Cart> getCartByUser_id(Integer id){
        return cartRepository.getCartByUser_id(id);
    }
    public void deleteCartByCart_id(Integer id){
        cartRepository.deleteCartByCart_id(id);
    }
    public void updateCartByCart_id(Integer id,Integer user_id){
        cartRepository.updateCartByCart_id(id,user_id);
    }

    public void addCart(Integer user_id){
        cartRepository.addCart(user_id);
    }
}