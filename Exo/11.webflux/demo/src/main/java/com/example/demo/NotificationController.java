package com.example.demo;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
public class NotificationController {

    private final NotificationService notificationService;

    public NotificationController(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @GetMapping("/notifications")
    public Flux<Notification> getNotifications() {
        return notificationService.getNotifications();
    }

    @GetMapping("/urgent")
    public Flux<Notification> getUrgentNotifications() {
        return notificationService.getFilteredNotifications();
    }

}
