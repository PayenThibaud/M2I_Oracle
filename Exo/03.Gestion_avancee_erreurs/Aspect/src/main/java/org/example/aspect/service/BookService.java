package org.example.aspect.service;

import org.example.aspect.annotation.ExceptionAspect;
import org.example.aspect.annotation.LogginAspect;
import org.example.aspect.annotation.PerformanceAspect;
import org.example.aspect.entity.Book;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class BookService {

    private Map<Integer, Book> books = new HashMap<>();

    @LogginAspect
    @PerformanceAspect
    public Book createBook(int id, String titre, String auteur) {
        Book book = new Book(titre, auteur);
        books.put(id, book);
        return book;
    }

    @LogginAspect
    @PerformanceAspect
    @ExceptionAspect
    public Book getBook(int id) {
        if (!books.containsKey(id)) {
            throw new RuntimeException("ID : " + id + " n existe pas pour get");
        }
        return books.get(id);
    }

    @LogginAspect
    @PerformanceAspect
    @ExceptionAspect
    public void deleteBook(int id) {
        if (!books.containsKey(id)) {
            throw new RuntimeException("ID : " + id + " n existe pas pour delete");
        }
        books.remove(id);
    }
}
