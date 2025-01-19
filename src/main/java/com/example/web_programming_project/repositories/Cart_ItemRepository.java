package com.example.web_programming_project.repositories;

import com.example.web_programming_project.dtos.CartItemProductDTO;
import com.example.web_programming_project.entities.Cart_Item;
import com.example.web_programming_project.entities.OrderItem;
import com.example.web_programming_project.entities.Product;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface Cart_ItemRepository extends CrudRepository<Cart_Item, Integer> {

    @Query(value = "SELECT * FROM Cart_Item" , nativeQuery = true)
    public List<Cart_Item> getAllCart_Item();
    @Modifying
    @Transactional
    @Query(value = "DELETE FROM Cart_Item WHERE cart_item_id =?1")
    public void deleteCart_ItemByCart_item_id(Integer id);
    @Modifying
    @Transactional
    @Query(value = "UPDATE Cart_Item SET quantity=?2 WHERE cart_item_id = ?1")
    public void updatequantityBycart_item_id(Integer cart_item_id,Integer quantity);

    @Query(value="SELECT * FROM Cart_Item a WHERE a.cart_item_id=:id", nativeQuery=true)
    List<Cart_Item> getCartItemByCartItem_id(@Param("id") Integer id);
    @Modifying
    @Transactional
    @Query(
            value =
                    "INSERT INTO Cart_Item (cart_id,product_id,quantity) values (?1,?2,?3)",
            nativeQuery = true)
    void addCartItem(Integer cart_id,Integer product_id,Integer quantity);
    @Modifying
    @Transactional
    @Query(value="SELECT ci.cart_item_id, c.cart_id, p.product_id, p.name, p.description, p.price, p.image, p.stock, ci.quantity " +
            "FROM Cart AS c JOIN Cart_Item AS ci ON c.cart_id = ci.cart_id " +
            "JOIN Product AS p ON ci.product_id = p.product_id WHERE c.user_id=?1", nativeQuery=true)
    List<Object[]> getCart_ItemByUserId(@Param("id") Integer id);
}