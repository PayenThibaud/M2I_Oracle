package org.example.command.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data

public class Command {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String produit;
    private double price;
    private LocalDate date;
}
