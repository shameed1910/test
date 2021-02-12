package com.example.firebase.springbootfirebase.controller;

import com.example.firebase.springbootfirebase.entity.Product;
import com.example.firebase.springbootfirebase.service.ProductService;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.firebase.cloud.FirestoreClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/api")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/products")
    public String createProduct(@RequestBody Product product) throws ExecutionException, InterruptedException {

       return productService.saveProduct(product);

    }

    @PutMapping("/products")
    public String updateProduct(@RequestBody Product productDetails) throws ExecutionException, InterruptedException
    {
        /*Product product= productService.getProductDetails();
        product.setName(productDetails.getName());
        product.setDescription(productDetails.getDescription());*/
        return productService.updateProductDetails(productDetails);
    }

    @GetMapping("/products")
    public List<Product> getAllProductDetails() throws ExecutionException, InterruptedException {
        return productService.getAllProductDetails();
    }

    @GetMapping("/products/{name}")
    public Product getProductDetails(@PathVariable(value = "name") String name) throws ExecutionException, InterruptedException {
        Product product=productService.getProductDetails(name);
        return product;
    }

    @DeleteMapping("/products/{name}")
    public String deleteProduct(@PathVariable(value = "name") String name) throws ExecutionException, InterruptedException {
        return productService.deleteProduct(name);

    }
}
