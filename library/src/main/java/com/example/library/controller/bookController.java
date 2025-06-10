package com.example.library.controller;

import com.example.library.model.bookModel;
import com.example.library.service.bookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/books")
public class bookController {
    private final bookService bookService;

    public bookController(bookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public ResponseEntity<List<bookModel>> getAllBooks() {
        return ResponseEntity.ok(bookService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<bookModel> getBookById(@PathVariable Long id) {
        bookModel book = bookService.findById(id);
        if (book != null) {
            return ResponseEntity.ok(book);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<bookModel> createBook(@RequestBody bookModel book) {
        bookModel savedBook = bookService.save(book);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedBook);
    }

    @PutMapping("/{id}")
    public ResponseEntity<bookModel> updateBook(@PathVariable Long id, @RequestBody bookModel book) {
        bookModel existingBook = bookService.findById(id);
        if (existingBook != null) {
            book.setId(id);
            bookModel updatedBook = bookService.save(book);
            return ResponseEntity.ok(updatedBook);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable Long id) {
        bookModel existingBook = bookService.findById(id);
        if (existingBook != null) {
            bookService.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}