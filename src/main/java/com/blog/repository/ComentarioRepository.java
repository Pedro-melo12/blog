package com.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blog.model.comentario;

public interface ComentarioRepository extends JpaRepository<comentario, Long> {
    
}
