package com.Inventory.Inventory.Model;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Products {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String brand;

    private double price;

    private int quantity;

    private String description;

    @ManyToOne
    @JoinColumn(name="category_id")
    private Category category;

}
