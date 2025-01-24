package com.example.web_programming_project.services;
import com.example.web_programming_project.entities.Order;
import com.example.web_programming_project.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
@Service
public class Orderservice {
    @Autowired
    private OrderRepository orderRepository;
    public List<Order> getAllOrders(){
        return orderRepository.getAllOrders();
    }
    public List<Order> getOrdersById(Integer id){
        return orderRepository.getOrdersById(id);
    }
    public void deleteOrderByOrderId(Integer id){
        orderRepository.deleteOrderByOrderId(id);
    }
    public void updateStatusById(Integer id,String status){
        orderRepository.updateStatusById(id,status);
    }
    public void updateTotalAmountById(Integer id ,BigDecimal amount){
        orderRepository.updateTotalAmountById(id,amount);
    }

    public void addOrder(Integer user_id, BigDecimal total_amount, String status){
        orderRepository.addOrder(user_id,total_amount,status);
    }
}


