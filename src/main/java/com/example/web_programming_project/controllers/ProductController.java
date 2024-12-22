package com.example.web_programming_project.controllers;


import com.example.web_programming_project.entities.Product;
import com.example.web_programming_project.services.Productservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
public class ProductController {
    @Autowired
    private Productservice productservice;
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
    public void postDetails(@RequestBody Product products){
        productservice.addProduct(products.getName(),products.getDescription(),products.getPrice()
                ,products.getStock(),products.getCategory_id());
    }
}
