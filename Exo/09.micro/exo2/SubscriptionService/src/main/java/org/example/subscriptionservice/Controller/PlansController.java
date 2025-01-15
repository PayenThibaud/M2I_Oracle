package org.example.subscriptionservice.Controller;

import org.example.subscriptionservice.Dto.Plans.PlansDtoReceive;
import org.example.subscriptionservice.Dto.Plans.PlansDtoSend;
import org.example.subscriptionservice.Service.PlansService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 POST http://localhost:8082/plans
 Content-Type: application/json

 {
 "name": "Premium Plan",
 "price": 29.99,
 "billingCycle": "MONTHLY"
 }
 */
@RestController
@RequestMapping("plans")
public class PlansController extends GeneriqueController<PlansDtoReceive, PlansDtoSend, PlansService> {

    public PlansController(PlansService service) {
        super(service);
    }
}
