package com.example.factorymethod.controller;

import com.example.factorymethod.dto.ProductRequest;
import com.example.factorymethod.factory.ProductFactory;
import com.example.factorymethod.model.Product;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/product")
public class ProductController {

    // Temporary in-memory storage (for demo purposes)
    private final List<Product> productList = new ArrayList<>();

    // POST to create a product
    @PostMapping("/create")
    public ResponseEntity<String> createProduct(@RequestBody ProductRequest productRequest) {
        Product product = ProductFactory.createProduct(
                productRequest.getType(),
                productRequest.getName(),
                productRequest.getDescription(),
                productRequest.getPrice()
        );
        productList.add(product); // Save to in-memory list
        return ResponseEntity.ok(product.displayInfo() + " ✅ Product created successfully!");
    }

    // GET to return all products
    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts() {
        return ResponseEntity.ok(productList);
    }
}
