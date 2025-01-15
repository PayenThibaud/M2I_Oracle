package org.example.subscriptionservice.Dto.Subscription;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class SubscriptionDtoSend {
    private int id_subscription;

    private LocalDate start_date;
    private LocalDate end_date;
    private String status;
    private int id_Plans;
    private String nomPlans;
    private int id_Client;
    private String nomClient;
}
