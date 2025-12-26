package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
public class Location {
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Double latitude;
    private Double longitude;

    public Location() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public Double getLatitude() { return latitude; }
    public void setLatitude(Double latitude) { this.latitude = latitude; }
    public Double getLongitude() { return longitude; }
    public void setLongitude(Double longitude) { this.longitude = longitude; }

    public static LocationBuilder builder() {
        return new LocationBuilder();
    }

    public static class LocationBuilder {
        private Location location = new Location();
        public LocationBuilder id(Long id) { location.setId(id); return this; }
        public LocationBuilder name(String name) { location.setName(name); return this; }
        public LocationBuilder latitude(Double latitude) { location.setLatitude(latitude); return this; }
        public LocationBuilder longitude(Double longitude) { location.setLongitude(longitude); return this; }
        public Location build() { return location; }
    }
}
