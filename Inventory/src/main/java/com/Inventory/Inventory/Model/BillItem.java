package com.Inventory.Inventory.Model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class BillItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int quantity;

    private double price;

    @ManyToOne
    @JoinColumn(name="product_id")
    private Products product;

    @ManyToOne
    @JoinColumn(name="bill_id")
    private Bill bill;
}