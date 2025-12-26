package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class Shipment {
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    public Shipment() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Vehicle getVehicle() { return vehicle; }
    public void setVehicle(Vehicle vehicle) { this.vehicle = vehicle; }
    public Location getPickupLocation() { return pickupLocation; }
    public void setPickupLocation(Location pickupLocation) { this.pickupLocation = pickupLocation; }
    public Location getDropLocation() { return dropLocation; }
    public void setDropLocation(Location dropLocation) { this.dropLocation = dropLocation; }
    public Double getWeightKg() { return weightKg; }
    public void setWeightKg(Double weightKg) { this.weightKg = weightKg; }
    public LocalDate getScheduledDate() { return scheduledDate; }
    public void setScheduledDate(LocalDate scheduledDate) { this.scheduledDate = scheduledDate; }

    public static ShipmentBuilder builder() {
        return new ShipmentBuilder();
    }

    public static class ShipmentBuilder {
        private Shipment shipment = new Shipment();
        public ShipmentBuilder id(Long id) { shipment.setId(id); return this; }
        public ShipmentBuilder vehicle(Vehicle vehicle) { shipment.setVehicle(vehicle); return this; }
        public ShipmentBuilder pickupLocation(Location pickupLocation) { shipment.setPickupLocation(pickupLocation); return this; }
        public ShipmentBuilder dropLocation(Location dropLocation) { shipment.setDropLocation(dropLocation); return this; }
        public ShipmentBuilder weightKg(Double weightKg) { shipment.setWeightKg(weightKg); return this; }
        public ShipmentBuilder scheduledDate(LocalDate scheduledDate) { shipment.setScheduledDate(scheduledDate); return this; }
        public Shipment build() { return shipment; }
    }
}
