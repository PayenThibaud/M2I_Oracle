package org.example.exo10.Error;

import org.springframework.boot.web.reactive.error.ErrorWebExceptionHandler;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

public class GlobalErrorHandler implements ErrorWebExceptionHandler {

    @Override
    public Mono<Void> handle(ServerWebExchange exchange, Throwable ex) {

        ServerHttpRequest request = exchange.getRequest();

        System.err.println("Erreur : " + ex.getMessage() + " pour la requete de " + request.getPath());

        exchange.getResponse().setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR);

        String errorMessage = String.format("{\"error\": \"%s\", \"path\": \"%s\"}", ex.getMessage(), request.getPath());

        byte[] bytes = errorMessage.getBytes();

        return exchange.getResponse().writeWith(Mono.just(exchange.getResponse().bufferFactory().wrap(bytes)));
    }
}
