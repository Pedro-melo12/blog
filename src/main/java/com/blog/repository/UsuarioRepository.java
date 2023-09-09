package com.blog.repository;





import org.springframework.data.jpa.repository.JpaRepository;

import com.blog.model.usuario;

public interface UsuarioRepository extends JpaRepository<usuario, Long> {
    
}
