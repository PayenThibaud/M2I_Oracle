package org.example.exo5;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class BookService {

    private final Map<Integer, Book> books = new ConcurrentHashMap<>();

    public BookService() {
        books.put(1, new Book(1, "Book 1", "Author 1"));
        books.put(2, new Book(2, "Book 2", "Author 2"));
        books.put(3, new Book(3, "Book 3", "Author 3"));
    }

    public Flux<Book> getAllBooks() {
        return Flux.fromIterable(books.values());
    }

    public Mono<Book> getBookById(int id) {
        return Mono.justOrEmpty(books.get(id));
    }

    public Mono<Book> addBook(Book book) {
        books.put(book.getId(), book);
        return Mono.just(book);
    }

    public Mono<Book> updateBook(int id, Book book) {
        books.put(id, book);
        return Mono.just(book);
    }

    public Mono<Void> deleteBook(int id) {
        books.remove(id);
        return Mono.empty();
    }

    public Flux<Book> getBooksByAuthor(String title) {
        return Flux.fromIterable(books.values()).filter(book -> book.getTitle().equals(title));
    }
}
