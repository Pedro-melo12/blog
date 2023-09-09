package com.blog.controller;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blog.model.Comentario;

public interface ComentarioController extends JpaRepository<Comentario, Long> {
    
}
