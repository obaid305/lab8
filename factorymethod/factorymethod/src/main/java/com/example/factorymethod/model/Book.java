package com.example.factorymethod.model;

public class Book implements Product {
    private String name;
    private String description;
    private double price;

    public Book(String name, String description, double price) {
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public String getName() { return name; }
    public String getDescription() { return description; }
    public double getPrice() { return price; }

    @Override
    public String displayInfo() {
        return "Book: " + name + ", " + description + ", $" + price;
    }
}
