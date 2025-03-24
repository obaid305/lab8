package com.example.prototypepattern.service;

import com.example.prototypepattern.model.Product;
import com.example.prototypepattern.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    // 1️⃣ Create a new product
    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    // 2️⃣ Clone product with a new color
    public Product cloneProduct(Long id, String newColor) {
        Product existingProduct = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found with id: " + id));

        Product clonedProduct = existingProduct.clone();
        clonedProduct.setId(null); // so it gets a new ID when saved
        clonedProduct.setColor(newColor);

        return productRepository.save(clonedProduct);
    }

    // 3️⃣ Get product by ID
    public Product getProduct(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found with id: " + id));
    }

    // 4️⃣ Get all products
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }
}
