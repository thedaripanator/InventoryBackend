package com.Inventory.Inventory.Repository;

import com.Inventory.Inventory.Model.Bill;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BillRepository extends JpaRepository<Bill,Long> {
}
