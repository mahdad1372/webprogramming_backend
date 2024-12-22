package com.example.web_programming_project.repositories;


import com.example.web_programming_project.entities.OrderItem;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OrderItemRepository extends JpaRepository<OrderItem,Integer>  {
    @Query(value = "SELECT s FROM OrderItem s")
    public List<OrderItem> getAllOrderItems();


    @Modifying
    @Transactional
    @Query(value = "DELETE FROM OrderItem WHERE order_item_id = ?1")
    public void deleteOrderItemById(@Param("id") Integer id);
    @Modifying
    @Transactional
    @Query(value = "UPDATE OrderItem SET quantity=?2 WHERE order_item_id = ?1")
    public void updateQuantityById(Integer id,Integer quantity);
    @Modifying
    @Transactional
    @Query(value = "UPDATE OrderItem SET price=?2 WHERE order_item_id = ?1")
    public void updatePriceById(Integer id,Integer price);

    @Query(value="SELECT * FROM OrderItem a WHERE a.order_item_id=?1", nativeQuery=true)
    List<OrderItem> getOrderItemById(@Param("id") Integer id);
    @Modifying
    @Transactional
    @Query(
            value =
                    "INSERT INTO OrderItem (order_id,product_id,quantity,price) values (?1,?2,?3)",
            nativeQuery = true)
    void addOrderItem(Integer order_id,Integer product_id,Integer quantity,Integer price);
}
