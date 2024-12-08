package com.example.touristhomestayplatform.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Homestay {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String location;
    private String description;
    private Double pricePerNight;  // Price per night for the homestay
    private String amenities;      // Amenities available in the homestay
    private String photos;        // URLs of images for the homestay

    @ManyToOne
    private User host;            // The host of the homestay

    // Getter for pricePerNight
    public Double getPricePerNight() {
        return pricePerNight;
    }

    // Setter for pricePerNight
    public void setPricePerNight(Double pricePerNight) {
        this.pricePerNight = pricePerNight;
    }

    // Getter for host
    public User getHost() {
        return host;
    }

    // Setter for host
    public void setHost(User host) {
        this.host = host;
    }

    // Getter for amenities
    public String getAmenities() {
        return amenities;
    }

    // Setter for amenities
    public void setAmenities(String amenities) {
        this.amenities = amenities;
    }

    // Getter for photos
    public String getPhotos() {
        return photos;
    }

    // Setter for photos
    public void setPhotos(String photos) {
        this.photos = photos;
    }

    // Getter for name
    public String getName() {
        return name;
    }

    // Setter for name
    public void setName(String name) {
        this.name = name;
    }

    // Getter for location
    public String getLocation() {
        return location;
    }

    // Setter for location
    public void setLocation(String location) {
        this.location = location;
    }

    // Getter for description
    public String getDescription() {
        return description;
    }

    // Setter for description
    public void setDescription(String description) {
        this.description = description;
    }
}
