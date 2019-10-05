package com.pj.springdatademo.service;

import com.pj.springdatademo.model.Category;
import com.pj.springdatademo.repo.CategoryRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
public class CategoryServiceImpl implements CategoryService
{
    private final CategoryRepository categoryRepository;
    private final ThreadPoolExecutorUtil threadPoolExecutorUtil;

    public CategoryServiceImpl(CategoryRepository categoryRepository, ThreadPoolExecutorUtil threadPoolExecutorUtil)
    {
        this.categoryRepository = categoryRepository;
        this.threadPoolExecutorUtil = threadPoolExecutorUtil;
    }

    @Override
    public List<Category> getAllCategoriesAsync()
    {
        for (int i=0;i<10000;i++)
        {
            Task task=new Task(categoryRepository);
            threadPoolExecutorUtil.executeTask(task);
        }
        Task task=new Task(categoryRepository);
        threadPoolExecutorUtil.executeTask(task);

        return task.categories;
    }

    @Override
    public List<Category> getAllCategories()
    {
        return categoryRepository.findAll(Sort.by(Sort.Direction.DESC, "id"));
        //return categoryRepository.getAllCategoriesThroughStoredProcedure();
    }

    @Override
    public Optional<Category> findCategoryById(Long id)
    {
        return categoryRepository.findById(id);
    }

    @Override
    public Category createCategory()
    {
        Category category = new Category();
        category.setId(new Random().nextLong());
        category.setCreatedOn(LocalDateTime.now());
        category.setName("Books");
        return categoryRepository.saveAndFlush(category);
    }
}
