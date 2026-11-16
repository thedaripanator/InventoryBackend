package com.Inventory.Inventory.Service;

import com.Inventory.Inventory.Model.Category;
import com.Inventory.Inventory.Model.Products;
import com.Inventory.Inventory.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repo;
    public void addProduct(Products product) {
        repo.save(product);
    }

    public void deleteProduct(int  id) {
        repo.deleteById(id);
    }


    public void updateProducts(Products product, int id) {
        Products oldProduct =repo.findById(id).get();
        oldProduct.setName(product.getName());
        oldProduct.setPrice(product.getPrice());
        oldProduct.setQuantity(product.getQuantity());
        oldProduct.setCategory(product.getCategory());
        oldProduct.setBrand(product.getBrand());
        oldProduct.setDescription(product.getDescription());
        repo.save(oldProduct);
    }

    public List<Products> getProductsByCategory(int  id) {

        return repo.findByCategoryId(id);
    }

    public List<Products> getProductsByName(String name) {
        return repo.findByName(name);
    }

    public List<Products> getProductsByCategoryname(String name) {
        return repo.findByCategoryName(name);

    }

    public List<Products> findByprice(Double price1, Double price2) {
//        List<Products> list=new ArrayList<>();
        return repo.findBypriceBetween(price1,price2);
    }

    public List<Products> getAllProducts() {
        return repo.findAll();
    }

    public List<Products> getminimun() {

        return repo.findByQuantityLessThan(5);
    }
}
