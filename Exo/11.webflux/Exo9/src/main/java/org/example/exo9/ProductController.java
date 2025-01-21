package org.example.exo9;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public Flux<Product> getAllProducts() {
        return productService.findAll();
    }

    @GetMapping("{id}")
    public Mono<ResponseEntity<Product>> getProduct(@PathVariable int id) {
        return productService.findById(id).map(ResponseEntity::ok).defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @GetMapping("/search")
    public Mono<ResponseEntity<Flux<Product>>> searchProducts(@RequestParam String name) {
        return productService.findByName(name).hasElements()
                .flatMap(o -> Mono.just(o ? ResponseEntity.ok(productService.findByName(name)) : ResponseEntity.noContent().build()));
    }

     @PostMapping
    public Mono<ResponseEntity<Product>> addProduct(@RequestBody Product product) {
        return productService.save(product).map(ResponseEntity::ok).defaultIfEmpty(ResponseEntity.notFound().build());
     }

     @PutMapping("{id}")
    public Mono<ResponseEntity<Product>> updateProduct(@PathVariable int id, @RequestBody Product product) {
        return productService.update(id, product).map(ResponseEntity::ok).defaultIfEmpty(ResponseEntity.notFound().build());
     }

     @DeleteMapping("{id}")
    public Mono<ResponseEntity<Void>> deleteProduct(@PathVariable int id) {
        return productService.deleteById(id).then(Mono.just(ResponseEntity.noContent().build()));
     }

     @PutMapping("{id}/buy")
    public Mono<ResponseEntity<Void>> buyProduct(@PathVariable int id, @RequestParam int quantity) {
        return  productService.buyProduct(id, quantity).then(Mono.just(ResponseEntity.noContent().build()));
     }
}
