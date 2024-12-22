package com.example.web_programming_project.services;


import com.example.web_programming_project.entities.Category;
import com.example.web_programming_project.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class Categoryservice {
    @Autowired
    private CategoryRepository categoryRepository;
    public List<Category> getallCategory(){
        return categoryRepository.getAllCategories();
    }
    public List<Category> getCategoryById(Integer id){
        return categoryRepository.getCategoriesByCategory_id(id);
    }
    public void deletecategorybyId(Integer id){
        categoryRepository.deleteCategoriesByid(id);
    }
    public void updatcategoryById(Integer id,String name){
        categoryRepository.updatecategorybyId(id,name);
    }

    public void addCategory(String name,String description){
        categoryRepository.addcategory(name,description);
    }
}
