package com.example.web_programming_project.controllers;


import com.example.web_programming_project.entities.Category;
import com.example.web_programming_project.services.Categoryservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RequestMapping("/category")
@RestController
public class CategoryController {
    @Autowired
    private Categoryservice categoryservice;
    @PutMapping("/updatecategory")
    public void updateCategory(@RequestBody Category categories){
        categoryservice.updatcategoryById(categories.getCategory_id(),categories.getName());
    }
    @GetMapping("/getcategory")
    public List<Category> getCategory(){
        return categoryservice.getallCategory();
    }
    @DeleteMapping("/deletecategory")
    public void deletecategory(@RequestBody Category categories) {
        categoryservice.deletecategorybyId(categories.getCategory_id());
    }
    @GetMapping("/getcategory/{id}")
    public List<Category> getcategorybyId(@PathVariable("id") Integer id){
        return categoryservice.getCategoryById(id);
    }
    @PostMapping("/addcategory")
    public void postDetails(@RequestBody Category category){
        categoryservice.addCategory(category.getName(),category.getDescription());
    }
}

