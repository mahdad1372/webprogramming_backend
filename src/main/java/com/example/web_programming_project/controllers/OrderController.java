package com.example.web_programming_project.controllers;

import com.example.web_programming_project.entities.Order;
import com.example.web_programming_project.services.Orderservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
public class OrderController {
    @Autowired
    private Orderservice orderservice;
    @PutMapping("/updateorder/status")
    public void updateOrder(@RequestBody Order orders){
        orderservice.updateStatusById(orders.getOrder_id(),orders.getStatus());
    }
    @PutMapping("/updateorder/amount")
    public void updateOrderAmount(@RequestBody Order orders){
        orderservice.updateTotalAmountById(orders.getOrder_id(),orders.getTotal_amount());
    }
    @GetMapping("/getorders")
    public List<Order> getOrders(){
        return orderservice.getAllOrders();
    }
    @DeleteMapping("/deleteorder/{id}")
    public void deleteOrderById(@PathVariable("id") Integer id) {
        orderservice.deleteOrderByOrderId(id);
    }
    @GetMapping("/getorder/{id}")
    public List<Order> getcategorybyId(@PathVariable("id") Integer id){
        return orderservice.getOrdersById(id);
    }
    @PostMapping("/addOrder")
    public void addOrder(@RequestBody Order orders){
        orderservice.addOrder(orders.getUser_id(),orders.getTotal_amount(),orders.getStatus());
    }
}