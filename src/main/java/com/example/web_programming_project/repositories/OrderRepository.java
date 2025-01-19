package com.example.web_programming_project.repositories;


import com.example.web_programming_project.entities.Order;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.security.Timestamp;
import java.util.List;

public interface OrderRepository extends JpaRepository<Order,Integer> {
    @Query(value = "SELECT s FROM Order s")
    public List<Order> getAllOrders();


    @Modifying
    @Transactional
    @Query(value = "DELETE FROM Order WHERE order_id = ?1",nativeQuery = true)
    public void deleteOrderByOrderId(@Param("id") Integer id);
    @Modifying
    @Transactional
    @Query(value = "UPDATE Order SET status=?2 WHERE order_id = ?1",nativeQuery = true)
    public void updateStatusById(Integer id,String status);
    @Modifying
    @Transactional
    @Query(value = "UPDATE Order SET total_amount=?2 WHERE order_id = ?1",nativeQuery = true)
    public void updateTotalAmountById(Integer id,Integer total_amount);

    @Query(value="SELECT * FROM Orders a WHERE a.order_id=?1", nativeQuery=true)
    List<Order> getOrdersById(@Param("id") Integer id);
    @Modifying
    @Transactional
    @Query(
            value =
                    "INSERT INTO `Order` (user_id,total_amount,status) values (?1,?2,?3)",
            nativeQuery = true)
    void addOrder(Integer user_id, Integer total_amount, String status);
}
