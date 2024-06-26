package com.blog.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blog.model.comentario;
import com.blog.repository.ComentarioRepository;

@RestController
@RequestMapping(value = "/comentarios")
public class ComentarioController {
    
    @Autowired
    private ComentarioRepository comentarioRepository;

     @PostMapping
    public ResponseEntity<comentario> cadastrarComentario(@RequestBody comentario comentario) {
        return ResponseEntity.status(HttpStatus.CREATED).body(comentarioRepository.save(comentario));
    }

    @PutMapping("/{id}")
    public ResponseEntity<comentario> atualizarComentario(@PathVariable("id") Long id, @RequestBody comentario comentario) {
        Optional<comentario> comentarioExistente = comentarioRepository.findById(id);

        if (comentarioExistente.isPresent()) {
            
            comentarioExistente.get().setTexto(comentario.getTexto());
            comentarioExistente.get().setDataDeCriacao(comentario.getDataDeCriacao());
            comentarioExistente.get().setUsuario(comentario.getUsuario());
            comentarioExistente.get().setPost(comentario.getPost());
            
            return ResponseEntity.status(HttpStatus.OK).body(comentarioRepository.save(comentarioExistente.get()));
        }
         return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

       
    

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletarcomentarioPeloId(@PathVariable Long id) {
        Optional<comentario> comentario = comentarioRepository.findById(id);

        if (comentario.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        comentarioRepository.deleteById(id);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("comentario deletada com sucesso!");
    }


}

