package com.Inventory.Inventory.DTO;

import lombok.Data;
import java.util.List;

@Data
public class BillRequest {

    private String customerName;
    private String phoneNumber;

    private List<Item> items;

    @Data
    public static class Item {

        private int productId;
        private int quantity;

    }
}