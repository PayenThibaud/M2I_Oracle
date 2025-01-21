package org.example.exo5;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class BookRouter {

    @Bean
    public RouterFunction<ServerResponse> bookRoutes(BookHandler bookHandler) {
        return route(GET("/api/books"), bookHandler::getAllBook)
                .andRoute(GET("/api/books/{id}"), bookHandler::getBookById)
                .andRoute(GET("/api/books/search?title=XYZ"), bookHandler::getBooksByTitle)
                .andRoute(POST("/api/books"), bookHandler::createBook)
                .andRoute(PUT("/api/books/{id}"), bookHandler::updateBook)
                .andRoute(DELETE("/api/books/{id}"), bookHandler::deleteBook);
    }
}