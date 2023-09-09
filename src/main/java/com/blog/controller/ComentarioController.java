package com.blog.controller;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blog.model.comentario;

public interface ComentarioController extends JpaRepository<comentario, Long> {
    
}
