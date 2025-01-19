package com.example.web_programming_project.repositories;

import com.example.web_programming_project.entities.Cart;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CartRepository extends CrudRepository<Cart, Integer> {

    @Query(value = "SELECT * FROM Cart" , nativeQuery = true)
    public List<Cart> getAllCarts();
    @Modifying
    @Transactional
    @Query(value = "DELETE FROM Cart WHERE cart_id =?1")
    public void deleteCartByCart_id(Integer id);
    @Modifying
    @Transactional
    @Query(value = "UPDATE Cart SET user_id=?2 WHERE cart_id = ?1")
    public void updateCartByCart_id(Integer cart_id,Integer user_id);

    @Query(value="SELECT * FROM Cart a WHERE a.cart_id=:id", nativeQuery=true)
    List<Cart> getCartByCart_id(@Param("id") Integer id);
    @Query(value="SELECT * FROM Cart a WHERE a.user_id=:id", nativeQuery=true)
    List<Cart> getCartByUser_id(@Param("id") Integer id);
    @Modifying
    @Transactional
    @Query(
            value =
                    "INSERT INTO Cart (user_id) values (?1)",
            nativeQuery = true)
    void addCart(Integer user_id);
}