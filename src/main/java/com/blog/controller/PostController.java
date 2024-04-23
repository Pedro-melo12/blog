package com.blog.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blog.model.post;

import com.blog.repository.PostRepository;

@RestController
@RequestMapping(value = "/posts")
public class PostController {

    @Autowired
    private PostRepository postRepository;

    @GetMapping
    public ResponseEntity<List<post>> listarPosts(post post) {
        return ResponseEntity.status(HttpStatus.OK).body(postRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<post> listarPostsPeloId(@PathVariable("id") Long id) {
        Optional<post> post = postRepository.findById(id);

        if (post.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        return ResponseEntity.status(HttpStatus.OK).body(post.get());
    }

    @PostMapping
    public ResponseEntity<post> cadastrarPosts(@RequestBody post post) {
        return ResponseEntity.status(HttpStatus.CREATED).body(postRepository.save(post));
    }

    @PutMapping("/{id}")
    public ResponseEntity<post> atualizarPosts(@PathVariable("id") Long id, @RequestBody post post) {
        Optional<post> postExistente = postRepository.findById(id);

        if (postExistente.isPresent()) {
            postExistente.get().setTitulo(post.getTitulo());
            postExistente.get().setConteudo(post.getConteudo());
            postExistente.get().setDataDeCriacao(post.getDataDeCriacao());
            postExistente.get().setUsuario(post.getUsuario());

            return ResponseEntity.status(HttpStatus.OK).body(postRepository.save(postExistente.get()));
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletarPostPeloId(@PathVariable Long id) {
        Optional<post> post = postRepository.findById(id);

        if (post.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        postRepository.deleteById(id);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("post deletada com sucesso!");
    }

}
