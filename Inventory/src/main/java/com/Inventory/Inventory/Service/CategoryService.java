package com.Inventory.Inventory.Service;

import com.Inventory.Inventory.Model.Category;
import com.Inventory.Inventory.Repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository repo;
    public void addCategory(Category category) {
        repo.save(category);
    }

    public void deleteCategory(Long id) {
        repo.deleteById(id);
    }

    public List<Category> getAllCategory() {
        return repo.findAll();
    }

    public void editCategory(Long id,Category category) {
        Category oldCategory = repo.findById(id).get();
        oldCategory.setName(category.getName());
        repo.save(oldCategory);
    }
}
