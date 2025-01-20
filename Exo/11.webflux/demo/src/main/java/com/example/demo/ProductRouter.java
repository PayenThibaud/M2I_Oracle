package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;


@Configuration
public class ProductRouter {

    @Bean
    public RouterFunction<ServerResponse> productRouter(ProductHandler productHandler){
        return route(GET("api/products"), productHandler::getAllProduct)
                .andRoute(GET("api/products/{id}", productHandler::getProductById))
    }
}
