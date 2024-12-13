package org.example.aspect.controller;

import org.example.aspect.entity.Book;
import org.example.aspect.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @PostMapping
    public Book createBook(@RequestParam int id, @RequestParam String titre, @RequestParam String auteur) {
        return bookService.createBook(id, titre, auteur);
    }

    @GetMapping
    public ResponseEntity<Book> getBook(@RequestParam int id) {
        try {
            Book book = bookService.getBook(id);
            return new ResponseEntity<>(book, HttpStatus.OK);
        } catch (RuntimeException ex) {
            throw ex;
        }
    }

    @DeleteMapping
    public ResponseEntity<String> deleteBook(@RequestParam int id) {
        try {
            bookService.deleteBook(id);
            return new ResponseEntity<>("Book deleted", HttpStatus.OK);
        } catch (RuntimeException ex) {
            throw ex;
        }
    }
}