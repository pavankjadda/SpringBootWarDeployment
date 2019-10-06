package com.pj.springbootwardeploymentdemo.service;

import com.pj.springbootwardeploymentdemo.model.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryService
{
    List<Category> getAllCategoriesAsync();

    List<Category> getAllCategories();

    Optional<Category> findCategoryById(Long id);

    Category createCategory();
}
