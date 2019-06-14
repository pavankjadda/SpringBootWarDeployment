package com.pj.springdatademo.repo;

import com.pj.springdatademo.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category,Long>,CategoryRepositoryCustom
{

    /*@Query(name = "CALL get_all_categories;", nativeQuery = true)
    List<Category> getAllCategoriesThroughStoredProcedure();*/

    /*
        @Procedure(procedureName="get_all_categories")
        List<Category> getAllCategoriesThroughStoredProcedure();
    */
}
