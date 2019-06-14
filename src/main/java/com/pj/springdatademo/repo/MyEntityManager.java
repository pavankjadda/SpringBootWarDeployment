package com.pj.springdatademo.repo;

import lombok.Data;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
@Data
public class MyEntityManager
{
    private final EntityManager entityManager;

    public MyEntityManager(EntityManager entityManager)
    {
        this.entityManager = entityManager;
    }
}
