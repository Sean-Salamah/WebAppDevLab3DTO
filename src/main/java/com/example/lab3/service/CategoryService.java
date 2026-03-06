package com.example.lab3.service;

import com.example.lab3.domain.Category;
import com.example.lab3.repository.CategoryRepository;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {
    private final CategoryRepository categoryRepository;


    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public Category createCategory(Category category)
    {
        return categoryRepository.save(category);
    }

}
