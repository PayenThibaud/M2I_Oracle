package org.example.subscriptionservice.Dto.Plans;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.subscriptionservice.Utils.Enums.Billing_cycle;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class PlansDtoSend {
    private int id_plans;
    private String name;
    private double price;
    private Billing_cycle billingCycle;
}
