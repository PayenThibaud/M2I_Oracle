package org.example.exo6;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import static org.springframework.web.reactive.function.server.ServerResponse.*;

@Component
public class TaskHandler {

    private final TaskService taskService;

    public TaskHandler(TaskService taskService) {
        this.taskService = taskService;
    }

    public Mono<ServerResponse> getAllTask(ServerRequest request) {
        return ok().body(taskService.getTasks(), Task.class);
    }

    public Mono<ServerResponse> getTaskById(ServerRequest request) {
        int id = Integer.parseInt(request.pathVariable("id"));
        return ok().body(taskService.getTask(id), Task.class);
    }

    public Mono<ServerResponse> getTaskById2(ServerRequest request) {
        int id = Integer.parseInt(request.pathVariable("id"));
        return taskService.getTask(id).flatMap(task -> ok().bodyValue(task)).switchIfEmpty(notFound().build());
    }

    public Mono<ServerResponse> createTask(ServerRequest request) {
        return request.bodyToMono(Task.class)
                .flatMap(taskService::createTask)
                .flatMap(task -> created(request.uri()).bodyValue(task));
    }

    public Mono<ServerResponse> updateTask(ServerRequest request) {
        int id = Integer.parseInt(request.pathVariable("id"));

        return request.bodyToMono(Task.class)
                .flatMap(task -> taskService.updateTask(id, task)
                        .flatMap(taskMaj -> ok().bodyValue(taskMaj)).switchIfEmpty(notFound().build()));
    }


    public Mono<ServerResponse> deleteTask(ServerRequest request) {
        int id = Integer.parseInt(request.pathVariable("id"));
        return taskService.deleteTask(id).flatMap(task -> ok().bodyValue(task).switchIfEmpty(notFound().build()));
    }
}
