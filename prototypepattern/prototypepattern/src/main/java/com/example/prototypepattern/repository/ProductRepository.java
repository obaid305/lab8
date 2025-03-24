package com.example.prototypepattern.repository;

import com.example.prototypepattern.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
