package com.Inventory.Inventory.Repository;

import com.Inventory.Inventory.Model.BillItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BillItemRepository extends JpaRepository<BillItem,Long> {
}
