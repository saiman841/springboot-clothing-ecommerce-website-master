package com.myproject.apparelshop.service;

import com.myproject.apparelshop.model.Category;
import com.myproject.apparelshop.repository_dao.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    CategoryRepository categoryRepository;

    public List<Category> getAllCategory() {
        return categoryRepository.findAll();
    }

    public Optional<Category> getCategoryById(int id) { // optional because model may exist or may not.
        return categoryRepository.findById(id);
    }

    @Transactional
    public void addCategory(Category category) {
        categoryRepository.save(category);
    }

    public void deleteCategoryById(int id) {
        categoryRepository.deleteById(id);
    }


}

// In this class we can write business logic, this class is not mandatory but it is a good practice. (mediating business role between repository and controller)