package com.pj.springbootwardeploymentdemo.service;

import com.pj.springbootwardeploymentdemo.model.Category;
import com.pj.springbootwardeploymentdemo.repo.CategoryRepository;

import java.util.List;

public class Task implements Runnable
{
    private final CategoryRepository categoryRepository;
    List<Category> categories;

    Task(CategoryRepository categoryRepository)
    {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void run()
    {
        categories=categoryRepository.getAllCategoriesThroughStoredProcedure();
    }
}
