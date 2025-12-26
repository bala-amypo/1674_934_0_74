package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class Vehicle {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String vehicleNumber;
    private Double capacityKg;
    private Double fuelEfficiency;
    
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
