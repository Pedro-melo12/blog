package com.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blog.model.post;

public interface PostRepository extends JpaRepository<post, Long>  {
    
}
