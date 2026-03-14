package com.Inventory.Inventory.Repository;

import com.Inventory.Inventory.Model.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Products,Integer> {
    List<Products> findByCategoryId(int categoryId);
    List<Products> findByCategoryName(String Categoryname);
    List<Products> findByName(String productName);
    List<Products> findBypriceBetween(Double price1,Double price2);
}
