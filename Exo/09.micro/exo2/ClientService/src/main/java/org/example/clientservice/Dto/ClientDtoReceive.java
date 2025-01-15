package org.example.clientservice.Dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class ClientDtoReceive {
    private String nom;
    private int age;
    private String email;
    private String telephone;
}
