package com.Inventory.Inventory.Controller;

import com.Inventory.Inventory.Model.Category;
import com.Inventory.Inventory.Service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryService service;

    @PostMapping("/add")
    public void addCategory(@RequestBody Category category){
        service.addCategory(category);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteCategory(@PathVariable Long id){
        service.deleteCategory(id);
    }

    @GetMapping("/all")
    public List<Category> getAllCategory(){
        return service.getAllCategory();
    }

    @PutMapping("/add/{id}")
    public void addCategory(@PathVariable Long id, @RequestBody Category category){
        service.editCategory(id,category);
    }
}
