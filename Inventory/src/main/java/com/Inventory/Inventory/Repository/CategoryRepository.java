package com.Inventory.Inventory.Repository;

import com.Inventory.Inventory.Model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository  extends JpaRepository<Category,Long> {
}
