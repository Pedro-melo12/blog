package com.blog.model;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity(name = "tb_comentarios")
public class comentario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idComentario;

    @Column(columnDefinition = "TEXT")
    private String texto;

    @Column(nullable = false)
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataDeCriacao;

    @ManyToOne
    @JoinColumn(name = "idUsuario")
    private usuario usuario;

    @ManyToOne
    @JoinColumn(name = "idPost")
    private post post;
}
