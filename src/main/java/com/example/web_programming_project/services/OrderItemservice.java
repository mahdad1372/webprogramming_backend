package com.example.web_programming_project.services;

import com.example.web_programming_project.entities.OrderItem;
import com.example.web_programming_project.repositories.OrderItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class OrderItemservice {
    @Autowired
    private OrderItemRepository orderItemRepository;
    public List<OrderItem> getAllOrderItems(){
        return orderItemRepository.getAllOrderItems();
    }
    public List<OrderItem> getOrderItemById(Integer id){
        return orderItemRepository.getOrderItemById(id);
    }
    public void deleteOrderItemById(Integer id){
        orderItemRepository.deleteOrderItemById(id);
    }
    public void updateQuantityById(Integer id,Integer quantity){
        orderItemRepository.updateQuantityById(id,quantity);
    }
    public void updatePriceById(Integer id ,Integer price){
        orderItemRepository.updatePriceById(id,price);
    }

    public void addOrderItem(Integer order_id,Integer product_id,Integer quantity,Integer price){
        orderItemRepository.addOrderItem(order_id,product_id,quantity,price);
    }
}