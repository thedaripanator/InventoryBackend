package com.Inventory.Inventory.Controller;

import com.Inventory.Inventory.Model.Category;
import com.Inventory.Inventory.Model.Products;
import com.Inventory.Inventory.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService service;

    @PostMapping("/add")
    public void AddProduct(@RequestBody Products product){
        service.addProduct(product);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteProduct(@PathVariable int id){
        service.deleteProduct(id);
    }

    @PutMapping("/edit/{id}")
    public void updateProduct(@RequestBody Products product, @PathVariable int id){
        service.updateProducts(product,id);
    }

    @GetMapping("/category/{id}")
    public List<Products> findByCategory(@PathVariable int id){
        return service.getProductsByCategory(id);
    }

    @GetMapping("/name/{name}")
    public List<Products> fingByName(@PathVariable String name){
        return service.getProductsByName(name);
    }
    @GetMapping("/categoryname/{name}")
    public List<Products> findByCategoryName(@PathVariable String name){
        return service.getProductsByCategoryname(name);
    }
    @GetMapping("/price/{price1}/{price2}")
    public List<Products> findByprice(@PathVariable Double price1,@PathVariable Double price2){
        return service.findByprice(price1,price2);
    }
    @GetMapping("/all")
    public List<Products> getAllProducts(){
        return service.getAllProducts();
    }

    @GetMapping("/minStock")
    public List<Products> getMinStock(){
        return service.getminimun();
    }


}
