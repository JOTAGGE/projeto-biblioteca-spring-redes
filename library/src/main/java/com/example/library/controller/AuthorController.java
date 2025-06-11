package com.example.library.controller;

import com.example.library.model.AuthorModel;
import com.example.library.service.AuthorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/authors") // Define o caminho base para todos os endpoints deste controlador
public class AuthorController {

    private final AuthorService authorService;

    // Injeção de dependência do AuthorService via construtor
    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    /**
     * Lista todos os autores.
     * Endpoint: GET /authors
     */
    @GetMapping
    public ResponseEntity<List<AuthorModel>> getAllAuthors() {
        List<AuthorModel> authors = authorService.findAll();
        return ResponseEntity.ok(authors);
    }

    /**
     * Busca um autor pelo ID.
     * Endpoint: GET /authors/{id}
     */
    @GetMapping("/{id}")
    public ResponseEntity<AuthorModel> getAuthorById(@PathVariable Long id) {
        AuthorModel author = authorService.findById(id);
        if (author != null) {
            return ResponseEntity.ok(author);
        }
        return ResponseEntity.notFound().build(); // Retorna 404 se não encontrar
    }

    /**
     * Insere um novo autor.
     * Endpoint: POST /authors
     */
    @PostMapping
    public ResponseEntity<AuthorModel> createAuthor(@RequestBody AuthorModel author) {
        AuthorModel savedAuthor = authorService.save(author);
        return new ResponseEntity<>(savedAuthor, HttpStatus.CREATED); // Retorna 201 Created
    }

    /**
     * Atualiza um autor existente.
     * Endpoint: PUT /authors/{id}
     */
    @PutMapping("/{id}")
    public ResponseEntity<AuthorModel> updateAuthor(@PathVariable Long id, @RequestBody AuthorModel authorDetails) {
        AuthorModel existingAuthor = authorService.findById(id);
        if (existingAuthor != null) {
            existingAuthor.setName(authorDetails.getName());
            existingAuthor.setBirthDate(authorDetails.getBirthDate());
            AuthorModel updatedAuthor = authorService.save(existingAuthor);
            return ResponseEntity.ok(updatedAuthor);
        }
        return ResponseEntity.notFound().build();
    }

    /**
     * Deleta um autor pelo ID.
     * Endpoint: DELETE /authors/{id}
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAuthor(@PathVariable Long id) {
        AuthorModel author = authorService.findById(id);
        if (author != null) {
            authorService.deleteById(id);
            return ResponseEntity.noContent().build(); // Retorna 204 No Content
        }
        return ResponseEntity.notFound().build();
    }
}