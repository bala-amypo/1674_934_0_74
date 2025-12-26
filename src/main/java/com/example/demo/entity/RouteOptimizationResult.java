package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class RouteOptimizationResult {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "shipment_id")
    private Shipment shipment;
    
    private Double optimizedDistanceKm;
    private Double estimatedFuelUsageL;
    private LocalDateTime generatedAt;
}
