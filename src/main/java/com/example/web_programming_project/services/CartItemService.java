package com.example.web_programming_project.services;
import com.example.web_programming_project.entities.Cart_Item;
import com.example.web_programming_project.repositories.Cart_ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.web_programming_project.dtos.CartItemProductDTO;
import java.util.List;
@Service
public class CartItemService {
    @Autowired
    private Cart_ItemRepository cart_ItemRepository;
    public List<Cart_Item> getAllCart_Item(){
        return cart_ItemRepository.getAllCart_Item();
    }
    public List<Cart_Item> getCartItemByCartItem_id(Integer id){
        return cart_ItemRepository.getCartItemByCartItem_id(id);
    }

    public List<Object[]> getcartItemByUserId(Integer id){
        return cart_ItemRepository.getCart_ItemByUserId(id);
    }
    public void deleteCart_ItemByCart_item_id(Integer id){
        cart_ItemRepository.deleteCart_ItemByCart_item_id(id);
    }
    public void updatequantityBycart_item_id(Integer id,Integer user_id){
        cart_ItemRepository.updatequantityBycart_item_id(id,user_id);
    }

    public void addCartItem(Integer cart_id,Integer product_id,Integer quantity){
        cart_ItemRepository.addCartItem(cart_id,product_id,quantity);
    }
}
