package com.pj.springdatademo.repo;

import com.pj.springdatademo.model.PostDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostDetailRepository extends JpaRepository<PostDetail,Long>
{
}
