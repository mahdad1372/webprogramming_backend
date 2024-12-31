package com.example.web_programming_project.controllers;


import com.example.web_programming_project.entities.Product;
import com.example.web_programming_project.services.Productservice;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Base64;
import java.util.List;
@RestController
public class ProductController {
    public static String UPLOAD_DIRECTORY = System.getProperty("user.dir") + "/uploads";
    @Autowired
    private Productservice productservice;
    @PostConstruct
    public void init() {
        Path uploadDir = Paths.get(UPLOAD_DIRECTORY);
        if (!Files.exists(uploadDir)) {
            try {
                Files.createDirectories(uploadDir);
            } catch (IOException e) {
                throw new RuntimeException("Could not create upload directory!", e);
            }
        }
    }
    @PutMapping("/updateProduct")
    public void updateCategory(@RequestBody Product products){
        productservice.updateproductById(products.getProduct_id(),products.getName());
    }
    @GetMapping("/getproducts")
    public List<Product> getproducts(){
        return productservice.getallproducts();
    }
    @DeleteMapping("/deleteproducts")
    public void deleteproduct(@RequestBody Product products) {
        productservice.deleteproductbyId(products.getProduct_id());
    }
    @GetMapping("/getproduct/{id}")
    public List<Product> getcategorybyId(@PathVariable("id") Integer id){
        return productservice.getProductById(id);
    }
    @PostMapping("/addProduct")
    public ResponseEntity<String> postDetails(@RequestParam("name") String name,
                                              @RequestParam("description") String description,
                                              @RequestParam("price") Integer price,
                                              @RequestParam("stock") Integer stock,
                                              @RequestParam("category_id") Integer category_id, @RequestParam("image") MultipartFile image) throws IOException {
        Path filePath = Paths.get(UPLOAD_DIRECTORY, image.getOriginalFilename());
        Files.write(filePath, image.getBytes());
        String imageUrl = "/images/" + image.getOriginalFilename();
        productservice.addProduct(name, description, price, stock, category_id, imageUrl);

        return ResponseEntity.ok("Product added successfully with image.");

    }
    private String shortenBase64(String base64) {
        if (base64.length() <= 30) {  // If the string is already short, return it as-is
            return base64;
        }
        return base64.substring(0, 10) + "..." + base64.substring(base64.length() - 10);
    }
}
