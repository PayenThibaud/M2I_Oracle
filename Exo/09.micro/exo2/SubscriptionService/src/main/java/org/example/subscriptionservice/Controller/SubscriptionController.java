package org.example.subscriptionservice.Controller;


import org.example.subscriptionservice.Dto.Subscription.SubscriptionDtoReceive;
import org.example.subscriptionservice.Dto.Subscription.SubscriptionDtoSend;
import org.example.subscriptionservice.Service.SubscriptionService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 POST http://localhost:8082/subscription
 Content-Type: application/json

 {
 "start_date": "2025-01-01",
 "end_date": "2025-12-31",
 "status": "ACTIVE",
 "id_Client": 1,
 "id_Plans": 1
 }
 */

@RestController
@RequestMapping("subscription")
public class SubscriptionController extends GeneriqueController<SubscriptionDtoReceive, SubscriptionDtoSend, SubscriptionService> {

    public SubscriptionController(SubscriptionService service) {
        super(service);
    }
}