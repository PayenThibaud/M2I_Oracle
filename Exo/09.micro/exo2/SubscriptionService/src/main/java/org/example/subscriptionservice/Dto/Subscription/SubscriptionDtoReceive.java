package org.example.subscriptionservice.Dto.Subscription;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class SubscriptionDtoReceive {
    private LocalDate start_date;
    private LocalDate end_date;
    private String status;
    private int id_Plans;
    private int id_Client;
}
