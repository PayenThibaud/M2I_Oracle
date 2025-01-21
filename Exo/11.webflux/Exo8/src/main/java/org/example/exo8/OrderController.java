package org.example.exo8;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    private final OrderService orderService;

    public OrderController(final OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping
    public Flux<Order> getOrders() {
        return orderService.findAll();
    }

    @GetMapping("{id}")
    public Mono<ResponseEntity<Order>> getOrder(@PathVariable final int id) {
        return orderService.findById(id).map(ResponseEntity::ok).defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @GetMapping("/search")
    public Mono<ResponseEntity<Flux<Order>>> searchOrders(@RequestParam Status status) {
        return orderService.findByStatus(status)
                .hasElements()
                .flatMap(o -> Mono.just(o ? ResponseEntity.ok(orderService.findByStatus(status)) : ResponseEntity.noContent().build()));
    }

    @GetMapping("/paged")
    public Mono<ResponseEntity<Flux<Order>>> getPagedOrders(@RequestParam int page, @RequestParam int size){
        return orderService.findByPageable(page, size).hasElements()
                .flatMap(o -> Mono.just(o ? ResponseEntity.ok(orderService.findByPageable(page, size)) : ResponseEntity.noContent().build()));
    }

    @PostMapping
    public Mono<ResponseEntity<Order>> createOrder(@RequestBody final Order order) {
        return orderService.save(order).map(ResponseEntity::ok).defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @PutMapping("{id}")
    public Mono<ResponseEntity<Order>> updateOrder(@PathVariable int id,  @RequestBody final Order order) {
        return orderService.updateOrder(id, order).map(ResponseEntity::ok).defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @DeleteMapping("{id}")
    public Mono<ResponseEntity<Void>> deleteOrder(@PathVariable final int id) {
        return orderService.deleteById(id).then(Mono.just(ResponseEntity.noContent().build()));
    }



}
