package com.pj.springdatademo.service;

import com.pj.springdatademo.model.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryService
{
    List<Category> getAllCategoriesAsync();

    List<Category> getAllCategories();

    Optional<Category> findCategoryById(Long id);
}
