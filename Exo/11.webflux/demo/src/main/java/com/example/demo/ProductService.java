package com.example.demo;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class ProductService {

    private final Map<String, Product> products = new ConcurrentHashMap<>();

    public ProductService() {
        // Produit de test
        products.put("1", new Product("1", "Livre", BigDecimal.valueOf(0.99)));
        products.put("2", new Product("2", "Tomate", BigDecimal.valueOf(0.99)));
    }

    public Flux<Product> findAll() {
        return Flux.fromIterable(products.values());
    }

    public Mono<Product> findById(String id) {
        return Mono.justOrEmpty(products.get(id));
    }

    public Mono<Product> save(Product product) {
        String id = UUID.randomUUID().toString();
        product.setId(id);
        products.put(product.getId(), product);
        return Mono.just(product);

    }

}
