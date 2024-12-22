package com.example.web_programming_project.controllers;

import com.example.web_programming_project.entities.Cart;
import com.example.web_programming_project.entities.Cart_Item;
import com.example.web_programming_project.services.CartItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RequestMapping("/cart_item")
@RestController
public class Cart_ItemController {
    @Autowired
    private CartItemService cartItemService;
    @PutMapping("/update")
    public void updateCartByCart_id(@RequestBody Cart_Item cart_Item){
        cartItemService.updatequantityBycart_item_id(cart_Item.getCart_id(),cart_Item.getQuantity());
    }
    @GetMapping("/getall")
    public List<Cart_Item> getAllCarts(){
        return cartItemService.getAllCart_Item();
    }
    @DeleteMapping("/delete")
    public void deleteCart_ItemByCart_item_id(@RequestBody Cart_Item cart_Item) {
        cartItemService.deleteCart_ItemByCart_item_id(cart_Item.getCart_item_id());
    }
    @GetMapping("/getcart/{id}")
    public List<Cart_Item> getCartItemByCartItem_id(@PathVariable("id") Integer id){
        return cartItemService.getCartItemByCartItem_id(id);
    }
    @PostMapping("/addcart")
    public void addCart(@RequestBody Cart cart){
        cartItemService.addCartItem(cart.getUser_id());
    }
}
