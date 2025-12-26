package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class RouteOptimizationResult {
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "shipment_id")
    private Shipment shipment;
    
    private Double optimizedDistanceKm;
    private Double estimatedFuelUsageL;
    private LocalDateTime generatedAt;

    public RouteOptimizationResult() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Shipment getShipment() { return shipment; }
    public void setShipment(Shipment shipment) { this.shipment = shipment; }
    public Double getOptimizedDistanceKm() { return optimizedDistanceKm; }
    public void setOptimizedDistanceKm(Double optimizedDistanceKm) { this.optimizedDistanceKm = optimizedDistanceKm; }
    public Double getEstimatedFuelUsageL() { return estimatedFuelUsageL; }
    public void setEstimatedFuelUsageL(Double estimatedFuelUsageL) { this.estimatedFuelUsageL = estimatedFuelUsageL; }
    public LocalDateTime getGeneratedAt() { return generatedAt; }
    public void setGeneratedAt(LocalDateTime generatedAt) { this.generatedAt = generatedAt; }

    public static RouteOptimizationResultBuilder builder() {
        return new RouteOptimizationResultBuilder();
    }

    public static class RouteOptimizationResultBuilder {
        private RouteOptimizationResult result = new RouteOptimizationResult();
        public RouteOptimizationResultBuilder id(Long id) { result.setId(id); return this; }
        public RouteOptimizationResultBuilder shipment(Shipment shipment) { result.setShipment(shipment); return this; }
        public RouteOptimizationResultBuilder optimizedDistanceKm(Double distance) { result.setOptimizedDistanceKm(distance); return this; }
        public RouteOptimizationResultBuilder estimatedFuelUsageL(Double fuel) { result.setEstimatedFuelUsageL(fuel); return this; }
        public RouteOptimizationResultBuilder generatedAt(LocalDateTime generatedAt) { result.setGeneratedAt(generatedAt); return this; }
        public RouteOptimizationResult build() { return result; }
    }
}
