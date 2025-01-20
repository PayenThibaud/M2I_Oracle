package org.example.exo6;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class TaskService {

    private final Map<Integer, Task> tasks = new ConcurrentHashMap<>();

    public TaskService() {
        tasks.put(1, new Task(1, "description1", true));
        tasks.put(2, new Task(2, "description2", true));
        tasks.put(3, new Task(3, "description3", false));
    }

    public Flux<Task> getTasks() {
        return Flux.fromIterable(tasks.values());
    }

    public Mono<Task> getTask(int id) {
        return Mono.justOrEmpty(tasks.get(id));
    }

    public Mono<Task> createTask(Task task) {
        tasks.put(task.getId(), task);
        return Mono.justOrEmpty(task);
    }

    public Mono<Task> updateTask(int id, Task task) {
        tasks.put(id, task);
        return Mono.justOrEmpty(task);
    }

    public Mono<Void> deleteTask(int id) {
        tasks.remove(id);
        return Mono.empty();
    }
}
