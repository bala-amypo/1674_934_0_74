package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;

@Entity
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class Shipment {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "vehicle_id")
    private Vehicle vehicle;
    
    @ManyToOne
    @JoinColumn(name = "pickup_location_id")
    private Location pickupLocation;
    
    @ManyToOne
    @JoinColumn(name = "drop_location_id")
    private Location dropLocation;
    
    private Double weightKg;
    private LocalDate scheduledDate;
}
