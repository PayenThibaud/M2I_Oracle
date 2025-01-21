package org.example.exo9;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Flux<Product> findAll() {
        return productRepository.findAll();
    }

    public Mono<Product> findById(int id) {
        return productRepository.findById(id);
    }

    public Mono<Product> save(Product product) {
        return productRepository.save(product);
    }

    public Mono<Void> deleteById(int id) {
        return productRepository.deleteById(id);
    }

    public Mono<Product> update(int id ,Product product) {
        return productRepository.findById(id).flatMap(i ->{
            i.setName(product.getName());
            i.setPrice(product.getPrice());
            i.setStock(product.getStock());
            return productRepository.save(i);
        });
    }

    public Flux<Product> findByName(String name) {
        return productRepository.findByName(name);
    }

    public Mono<Product> buyProduct(int id, int quantity) {
        return productRepository.findById(id).flatMap(i ->{
            i.setStock( i.getStock() - quantity);
            return productRepository.save(i);
        });
    }
}
