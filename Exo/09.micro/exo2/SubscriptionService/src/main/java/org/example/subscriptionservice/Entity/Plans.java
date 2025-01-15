package org.example.subscriptionservice.Entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.subscriptionservice.Utils.Enums.Billing_cycle;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class Plans {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_plans;

    private String name;
    private double price;
    private Billing_cycle billingCycle;

}
