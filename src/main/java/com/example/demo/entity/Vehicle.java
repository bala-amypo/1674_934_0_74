package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
public class Vehicle {
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String vehicleNumber;
    private Double capacityKg;
    private Double fuelEfficiency;
    
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Vehicle() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getVehicleNumber() { return vehicleNumber; }
    public void setVehicleNumber(String vehicleNumber) { this.vehicleNumber = vehicleNumber; }
    public Double getCapacityKg() { return capacityKg; }
    public void setCapacityKg(Double capacityKg) { this.capacityKg = capacityKg; }
    public Double getFuelEfficiency() { return fuelEfficiency; }
    public void setFuelEfficiency(Double fuelEfficiency) { this.fuelEfficiency = fuelEfficiency; }
    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }

    public static VehicleBuilder builder() {
        return new VehicleBuilder();
    }

    public static class VehicleBuilder {
        private Vehicle vehicle = new Vehicle();
        public VehicleBuilder id(Long id) { vehicle.setId(id); return this; }
        public VehicleBuilder vehicleNumber(String vehicleNumber) { vehicle.setVehicleNumber(vehicleNumber); return this; }
        public VehicleBuilder capacityKg(Double capacityKg) { vehicle.setCapacityKg(capacityKg); return this; }
        public VehicleBuilder fuelEfficiency(Double fuelEfficiency) { vehicle.setFuelEfficiency(fuelEfficiency); return this; }
        public VehicleBuilder user(User user) { vehicle.setUser(user); return this; }
        public Vehicle build() { return vehicle; }
    }
}
