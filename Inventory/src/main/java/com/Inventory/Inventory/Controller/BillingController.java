package com.Inventory.Inventory.Controller;

import com.Inventory.Inventory.DTO.BillRequest;
import com.Inventory.Inventory.Model.Bill;
import com.Inventory.Inventory.Service.BillingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/billing")
public class BillingController {

    @Autowired
    private BillingService service;

    @PostMapping("/create")
    public Bill createBill(@RequestBody BillRequest request){
        return service.createBill(request);
    }

    @GetMapping("/allbills")
    public List<Bill> getAllBills(){
        return service.getallBill();
    }
}