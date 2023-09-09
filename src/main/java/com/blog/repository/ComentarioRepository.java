package com.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blog.model.Comentario;

public interface ComentarioRepository extends JpaRepository<Comentario, Long> {
    
}
