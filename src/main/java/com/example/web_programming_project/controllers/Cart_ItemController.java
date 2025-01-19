package com.example.web_programming_project.controllers;

import com.example.web_programming_project.dtos.CartItemProductDTO;
import com.example.web_programming_project.entities.Cart;
import com.example.web_programming_project.entities.Cart_Item;
import com.example.web_programming_project.services.CartItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    @GetMapping("/getcartbyuserId/{id}")
    public List<Map<String, Object>> getCartItemByUserId(@PathVariable("id") Integer id) {
        List<Object[]> results = cartItemService.getcartItemByUserId(id);
        List<Map<String, Object>> response = new ArrayList<>();

        for (Object[] row : results) {
            Map<String, Object> item = new HashMap<>();

            // Correctly map each field to its intended key
            item.put("cartId", row[1]);             // cartId is at index 1
            item.put("quantity", row[8]);          // quantity is at index 8
            item.put("description", row[4]);       // description is at index 4
            item.put("stock", row[7]);             // stock is at index 7
            item.put("productName", row[3]);       // productName is at index 3
            item.put("image", row[6]);             // image is at index 6
            item.put("cartItemId", row[0]);        // cartItemId is at index 0
            item.put("price", row[5]);             // price is at index 5
            item.put("productId", row[2]);         // productId is at index 2

            response.add(item);
        }

        return response;
    }
    @PostMapping("/addcart")
    public void addCart(@RequestBody Cart_Item Cart_Item){
        cartItemService.addCartItem(Cart_Item.getCart_id(),Cart_Item.getProduct_id(),Cart_Item.getQuantity());
    }
}
