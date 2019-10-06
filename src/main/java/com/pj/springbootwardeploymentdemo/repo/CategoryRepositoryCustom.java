package com.pj.springbootwardeploymentdemo.repo;

import com.pj.springbootwardeploymentdemo.model.Category;

import java.util.List;

public interface CategoryRepositoryCustom
{
    List<Category> getAllCategoriesThroughStoredProcedure();
}
