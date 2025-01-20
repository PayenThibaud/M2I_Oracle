package org.example.exo6;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class TaskRouter {

    @Bean
    public RouterFunction<ServerResponse> bookRoutes(TaskHandler taskHandler) {
        return route(GET("/api/tasks"), taskHandler::getAllTask)
                .andRoute(GET("/api/tasks/{id}"), taskHandler::getTaskById)
                .andRoute(GET("/api/tasks2/{id}"), taskHandler::getTaskById2)
                .andRoute(POST("/api/tasks"), taskHandler::createTask)
                .andRoute(PUT("/api/tasks/{id}"), taskHandler::updateTask)
                .andRoute(DELETE("/api/tasks/{id}"), taskHandler::deleteTask);
    }
}
