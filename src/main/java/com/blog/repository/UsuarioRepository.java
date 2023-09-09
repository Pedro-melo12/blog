package com.blog.repository;





import org.springframework.data.jpa.repository.JpaRepository;

import com.blog.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    
}
