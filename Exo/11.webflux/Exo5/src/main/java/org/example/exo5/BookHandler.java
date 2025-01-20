package org.example.exo5;

import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import static org.springframework.web.reactive.function.server.ServerResponse.*;

@Component
public class BookHandler {

    private final BookService bookService;

    public BookHandler(BookService bookService) {
        this.bookService = bookService;
    }

    public Mono<ServerResponse> getAllBook(ServerRequest request) {
        return ok().body(bookService.getAllBooks(), Book.class);
    }

    public Mono<ServerResponse> getBookById(ServerRequest request) {
        int id = Integer.parseInt(request.pathVariable("id"));
        return bookService.getBookById(id).flatMap(book -> ok().bodyValue(book)).switchIfEmpty(notFound().build());
    }

    public Mono<ServerResponse> createBook(ServerRequest request) {
        return request.bodyToMono(Book.class)
                .flatMap(bookService::addBook)
                .flatMap(book -> created(request.uri()).bodyValue(book));
    }

    public Mono<ServerResponse> updateBook(ServerRequest request) {
        int id = Integer.parseInt(request.pathVariable("id"));

        return request.bodyToMono(Book.class)
                .flatMap(book -> bookService.updateBook(id, book)
                        .flatMap(bookMaj -> ok().bodyValue(bookMaj)).switchIfEmpty(notFound().build()));
    }


    public Mono<ServerResponse> deleteBook(ServerRequest request) {
        int id = Integer.parseInt(request.pathVariable("id"));
        return bookService.deleteBook(id).flatMap(book -> ok().bodyValue(book).switchIfEmpty(notFound().build()));
    }
}
