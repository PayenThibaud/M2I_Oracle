package org.example.exo14.Controller;

import org.example.exo14.Entity.Order;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    private final List<Order> orders = new ArrayList<>(List.of(
            new Order(1, "Ordi"),
            new Order(2, "Tel"),
            new Order(3, "Tele")
    ));

    @GetMapping
    public Flux<Order> getOrders() {
        return Flux.fromIterable(orders);
    }

    @PostMapping
    public Mono<Order> createOrder(@RequestBody Order order) {
        orders.add(order);
        return Mono.just(order);
    }
}

