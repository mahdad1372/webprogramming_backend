package com.example.web_programming_project.repositories;

import com.example.web_programming_project.entities.Product;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Integer> {
    @Query(value = "SELECT * FROM Product", nativeQuery=true)
    public List<Product> getAllproducts();


    @Modifying
    @Transactional
    @Query(value = "DELETE FROM Product WHERE product_id = :id")
    public void deleteProductsById(Integer id);
    @Modifying
    @Transactional
    @Query(value = "UPDATE Product SET name=?2 WHERE product_id = ?1")
    public void updateproductById(Integer id,String name);

    @Query(value="SELECT * FROM Product a WHERE a.product_id=?1", nativeQuery=true)
    List<Product> getProductsById(@Param("id") Integer id);
    @Query(value="SELECT * FROM Product a WHERE a.category_id=?1", nativeQuery=true)
    List<Product> getProductsByIdCategory(@Param("id") Integer id);
    @Modifying
    @Transactional
    @Query(
            value =
                    "INSERT INTO Product (name,description,price,stock, category_id,image) values (?1,?2,?3,?4,?5,?6)",
            nativeQuery = true)
    void addProduct(String name,String description,Integer price,Integer stock,Integer category_id, String image);
}

