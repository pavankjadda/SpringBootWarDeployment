package com.pj.springbootwardeploymentdemo.web;

import com.pj.springbootwardeploymentdemo.model.Category;
import com.pj.springbootwardeploymentdemo.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/category")
public class CategoryController
{
    private final CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService)
    {
        this.categoryService = categoryService;
    }

    @GetMapping(path = "/list")
    public List<Category> getAllCategories()
    {
        return categoryService.getAllCategories();
    }

    @GetMapping(path = "/list/async")
    public List<Category> getAllCategoriesAsync()
    {
        return categoryService.getAllCategoriesAsync();
    }

    @GetMapping(path = "/{id}")
    public Optional<Category> getCategoryById(@PathVariable Long id)
    {
        return categoryService.findCategoryById(id);
    }

    @GetMapping(path = "/create")
    public Category createCategory()
    {
        return categoryService.createCategory();
    }
}
