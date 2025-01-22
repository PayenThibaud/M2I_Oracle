package org.example.exo8;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public Flux<Order> findAll() {
        return orderRepository.findAll();
    }

    public Mono<Order> findById(int id) {
        return orderRepository.findById(id);
    }

    public Mono<Order> save(Order order) {
        return orderRepository.save(order);
    }

    public Mono<Void> deleteById(int id) {
        return orderRepository.deleteById(id);
    }

    public Mono<Order> updateOrder(int id ,Order order) {
        return orderRepository.findById(id).flatMap(i ->{
            i.setCustomerName(order.getCustomerName());
            i.setStatus(order.getStatus());
            i.setTotalAmount(order.getTotalAmount());
            i.setCreatedAt(LocalDateTime.now());
            return orderRepository.save(i);
        });
    }

    public Flux<Order> findByStatus(Status status) {
        return orderRepository.findByStatus(status);
    }

    public Flux<Order> findByPageable(int page, int size) {
        Pageable pageable = PageRequest.of(page, size, Sort.by("createdAt").descending());
        return orderRepository.findAllBy(pageable);
    }
}
