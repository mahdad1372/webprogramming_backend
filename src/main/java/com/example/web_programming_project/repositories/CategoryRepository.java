package com.example.web_programming_project.repositories;

import com.example.web_programming_project.entities.Category;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CategoryRepository extends CrudRepository<Category, Integer> {

    @Query(value = "SELECT * FROM Category" , nativeQuery = true)
    public List<Category> getAllCategories();
    @Modifying
    @Transactional
    @Query(value = "DELETE FROM Category WHERE category_id =?1")
    public void deleteCategoriesByid(Integer id);
    @Modifying
    @Transactional
    @Query(value = "UPDATE Category SET name=?2 WHERE category_id = ?1")
    public void updatecategorybyId(Integer id,String name);

    @Query(value="SELECT * FROM Category a WHERE a.category_id=:id", nativeQuery=true)
    List<Category> getCategoriesByCategory_id(@Param("id") Integer id);
    @Modifying
    @Transactional
    @Query(
            value =
                    "INSERT INTO Category (name,description,image) values (?1,?2,?3)",
            nativeQuery = true)
    void addcategory(String name,String description,String image);
}
