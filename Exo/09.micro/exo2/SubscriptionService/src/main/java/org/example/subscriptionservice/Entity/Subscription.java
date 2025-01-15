package org.example.subscriptionservice.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class Subscription {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_subscription;

    private LocalDate start_date;
    private LocalDate end_date;
    private String status;

    @Column(name = "id_plans")
    private int idPlans;

    @Column(name = "id_client")
    private int idClient;


}
