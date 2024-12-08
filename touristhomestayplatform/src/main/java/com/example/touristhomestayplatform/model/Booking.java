package com.example.touristhomestayplatform.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private User tourist;  // The tourist who made the booking

    @ManyToOne
    private Homestay homestay;  // The homestay that is being booked

    private LocalDate checkInDate;  // Check-in date for the booking
    private LocalDate checkOutDate;  // Check-out date for the booking
    private Double totalPrice;  // Total price for the stay (calculated during booking)
    private String status;  // Booking status (PENDING, CONFIRMED, CANCELED)

    // Additional Getter and Setter methods if you are not using Lombok
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getTourist() {
        return tourist;
    }

    public void setTourist(User tourist) {
        this.tourist = tourist;
    }

    public Homestay getHomestay() {
        return homestay;
    }

    public void setHomestay(Homestay homestay) {
        this.homestay = homestay;
    }

    public LocalDate getCheckInDate() {
        return checkInDate;
    }

    public void setCheckInDate(LocalDate checkInDate) {
        this.checkInDate = checkInDate;
    }

    public LocalDate getCheckOutDate() {
        return checkOutDate;
    }

    public void setCheckOutDate(LocalDate checkOutDate) {
        this.checkOutDate = checkOutDate;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
