package com.blog.model;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class usuario {
    

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUsuario;

    @Column(nullable = false, length = 50 ) 
    private String nome;

    @Column(nullable = false, length = 150)
    private String sobrenome;

    @Column(nullable = false, length = 100)
    private String email;

    @Column(nullable = false,length = 20)
    private String senha;

}
