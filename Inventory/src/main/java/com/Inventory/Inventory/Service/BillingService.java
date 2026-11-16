package com.Inventory.Inventory.Service;


import com.Inventory.Inventory.DTO.BillRequest;
import com.Inventory.Inventory.Model.*;
import com.Inventory.Inventory.Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class BillingService {

    @Autowired
    private ProductRepository productRepo;

    @Autowired
    private BillRepository billRepo;

    @Autowired
    private BillItemRepository billItemRepo;

    public Bill createBill(BillRequest request){

        Bill bill = new Bill();
        bill.setCustomerName(request.getCustomerName());
        bill.setPhoneNumber(request.getPhoneNumber());
        bill.setBillDate(LocalDateTime.now());

        bill = billRepo.save(bill);   // ✅ Save bill first

        double total = 0;

        for(BillRequest.Item item : request.getItems()){

            Products product = productRepo.findById(item.getProductId())
                    .orElseThrow(() -> new RuntimeException("Product not found"));

            if(product.getQuantity() < item.getQuantity()){
                throw new RuntimeException("Insufficient stock");
            }

            product.setQuantity(product.getQuantity() - item.getQuantity());
            productRepo.save(product);

            BillItem billItem = new BillItem();
            billItem.setProduct(product);
            billItem.setQuantity(item.getQuantity());
            billItem.setPrice(product.getPrice());
            billItem.setBill(bill);   // now bill has ID

            billItemRepo.save(billItem);

            total += product.getPrice() * item.getQuantity();
        }

        bill.setTotalAmount(total);

        return billRepo.save(bill);
    }

    public List<Bill> getallBill() {
        return billRepo.findAll();
    }
}