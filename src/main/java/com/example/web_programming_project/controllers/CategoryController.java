package com.example.web_programming_project.controllers;


import com.example.web_programming_project.entities.Category;
import com.example.web_programming_project.services.Categoryservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;


@RequestMapping("/category")
@RestController
public class CategoryController {
    public static String UPLOAD_DIRECTORY = System.getProperty("user.dir") + "/uploads";
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
//    @PostMapping("/addcategory")
//    public void postDetails(@RequestBody Category category){
//        categoryservice.addCategory(category.getName(),category.getDescription());
//    }
@PostMapping("/addcategory")
public ResponseEntity<String> postDetails(@RequestParam("name") String name,
                                          @RequestParam("description") String description
                                         , @RequestParam("image") MultipartFile image) throws IOException {
    Path filePath = Paths.get(UPLOAD_DIRECTORY, image.getOriginalFilename());
    Files.write(filePath, image.getBytes());
    String imageUrl = "/images/" + image.getOriginalFilename();
    categoryservice.addCategory(name, description, imageUrl);

    return ResponseEntity.ok("Product added successfully with image.");

}
}

