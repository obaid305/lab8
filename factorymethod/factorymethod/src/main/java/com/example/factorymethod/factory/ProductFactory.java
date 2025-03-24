package com.example.factorymethod.factory;

import com.example.factorymethod.model.*;

public class ProductFactory {
    public static Product createProduct(String type, String name, String description, double price) {
        switch (type.toLowerCase()) {
            case "electronics":
                return new Electronics(name, description, price);
            case "clothing":
                return new Clothing(name, description, price);
            case "book":
                return new Book(name, description, price);
            default:
                throw new IllegalArgumentException("Unknown product type: " + type);
        }
    }
}
