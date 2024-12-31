package com.example.web_programming_project.services;

import com.example.web_programming_project.configs.ImageUtils;
import com.example.web_programming_project.entities.Product;
import com.example.web_programming_project.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.io.IOException;
import java.util.List;


@Service
public class Productservice {
    @Autowired
    private ProductRepository productRepository;
    public List<Product> getallproducts(){
        return productRepository.getAllproducts();
    }
//    public List<Product> getallproducts(){
//        List<Product> products = productRepository.getAllproducts();
//
//        return products.stream().map(product -> {
//            if (product.getImage() != null) {
//                String fullImage = product.getImage();
//                String truncatedImage = fullImage.length() > 20
//                        ? fullImage.substring(0, 10) + "..." + fullImage.substring(fullImage.length() - 10)
//                        : fullImage;
//                product.setImage(truncatedImage);
//            }
//            return product;
//        }).collect(Collectors.toList());
//    }

    public List<Product> getProductById(Integer id){
        return productRepository.getProductsById(id);
    }
    public void deleteproductbyId(Integer id){
        productRepository.deleteProductsById(id);
    }
    public void updateproductById(Integer id,String name){
        productRepository.updateproductById(id,name);
    }

    public void addProduct(String name, String description, Integer price, Integer stock_quantity, Integer category_id, String image) throws IOException {
//        byte[] compressedImage = ImageUtils.compressImage(image);
        productRepository.addProduct(name,description,price,stock_quantity, category_id,image);
    }
}
