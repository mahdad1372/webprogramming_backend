package com.example.web_programming_project.controllers;
import com.example.web_programming_project.entities.OrderItem;
import com.example.web_programming_project.services.OrderItemservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrderItemController {
    @Autowired
    private OrderItemservice orderItemservice;
    @PutMapping("/updateorderitem/price")
    public void updateOrder(@RequestBody OrderItem orderItem){
        orderItemservice.updatePriceById(orderItem.getOrder_item_id(),orderItem.getPrice());
    }
    @PutMapping("/updateorder/quantity")
    public void updateOrderAmount(@RequestBody OrderItem orderItem){
        orderItemservice.updateQuantityById(orderItem.getOrder_item_id(),orderItem.getQuantity());
    }
    @GetMapping("/getOrderItem")
    public List<OrderItem> getOrders(){
        return orderItemservice.getAllOrderItems();
    }
    @DeleteMapping("/deleteorderitem/{id}")
    public void deleteorderItemById(@PathVariable("id") Integer id) {
        orderItemservice.deleteOrderItemById(id);
    }
    @GetMapping("/getorderitem/{id}")
    public List<OrderItem> getOrderItemById(@PathVariable("id") Integer id){
        return orderItemservice.getOrderItemById(id);
    }
    @PostMapping("/addorderitem")
    public void addOrder(@RequestBody OrderItem orderItem){
        orderItemservice.addOrderItem(orderItem.getOrder_id(),orderItem.getProduct_id(),orderItem.getQuantity()
                ,orderItem.getPrice());
    }
}
