package com.example.prototypepattern.controller;

import com.example.prototypepattern.model.Product;
import com.example.prototypepattern.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    // 1️⃣ Create a new product
    @PostMapping("/create")
    public ResponseEntity<Product> createProduct(@RequestBody Product product) {
        Product savedProduct = productService.createProduct(product);
        return ResponseEntity.ok(savedProduct);
    }

    // 2️⃣ Clone product with different color
    @PostMapping("/clone/{id}")
    public ResponseEntity<Product> cloneProduct(@PathVariable Long id, @RequestParam String color) {
        Product clonedProduct = productService.cloneProduct(id, color);
        return ResponseEntity.ok(clonedProduct);
    }

    // 3️⃣ Get a product by ID
    @GetMapping("/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable Long id) {
        Product product = productService.getProduct(id);
        return ResponseEntity.ok(product);
    }

    // 4️⃣ Get all products
    @GetMapping("/all")
    public ResponseEntity<List<Product>> getAllProducts() {
        List<Product> products = productService.getAllProducts();
        return ResponseEntity.ok(products);
    }
}
