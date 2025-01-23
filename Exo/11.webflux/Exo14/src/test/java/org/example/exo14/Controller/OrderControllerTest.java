package org.example.exo14.Controller;

import org.example.exo14.Entity.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@WebFluxTest(controllers = OrderController.class)
public class OrderControllerTest {

    @Autowired
    private WebTestClient webTestClient;

    @Test
    public void testGetAllOrders() {
        webTestClient.get().uri("/api/orders")
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(Order.class);
    }

    @Test
    public void testPostOrder() {
        webTestClient.post().uri("/api/orders")
                .contentType(MediaType.APPLICATION_JSON)
                .body(Mono.just(new Order(3, "Test")), Order.class)
                .exchange()
                .expectStatus().isOk()
                .expectBody(Order.class);

        webTestClient.get().uri("/api/orders")
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(Order.class)
                .consumeWith(response -> {
                    List<Order> responseBody = response.getResponseBody();
                    assertNotNull(responseBody);
                    assertTrue(responseBody.stream().anyMatch(order -> "Test".equals(order.getItem())));
                });
    }
}
