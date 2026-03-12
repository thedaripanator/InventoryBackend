package com.Inventory.Inventory.Model;


import jakarta.persistence.*;

@Entity
public class Products {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private String brand;

    private double price;

    private int quantity;

    private String description;

    @ManyToOne
    @JoinColumn(name="category_id")
    private Category category;

}
