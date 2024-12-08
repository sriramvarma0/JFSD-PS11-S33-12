package com.example.touristhomestayplatform.service;

import com.example.touristhomestayplatform.dto.BookingDTO;
import com.example.touristhomestayplatform.model.Booking;
import com.example.touristhomestayplatform.model.Homestay;
import com.example.touristhomestayplatform.model.User;
import com.example.touristhomestayplatform.repository.BookingRepository;
import com.example.touristhomestayplatform.repository.HomestayRepository;
import com.example.touristhomestayplatform.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private HomestayRepository homestayRepository;

    @Autowired
    private UserRepository userRepository;

    // Method to book a homestay
    public void bookHomestay(BookingDTO bookingDTO) {
        Homestay homestay = homestayRepository.findById(bookingDTO.getHomestayId()).orElse(null);
        User user = userRepository.findById(bookingDTO.getUserId()).orElse(null);

        if (homestay != null && user != null) {
            Booking booking = new Booking();
            booking.setTourist(user);
            booking.setHomestay(homestay);
            booking.setCheckInDate(bookingDTO.getCheckInDate());
            booking.setCheckOutDate(bookingDTO.getCheckOutDate());

            // Calculate total price based on number of nights and homestay price per night
            long days = ChronoUnit.DAYS.between(bookingDTO.getCheckInDate(), bookingDTO.getCheckOutDate());
            double totalPrice = days * homestay.getPricePerNight();
            booking.setTotalPrice(totalPrice);

            booking.setStatus("PENDING"); // Initial status
            bookingRepository.save(booking);
        }
    }

    // Method to confirm a booking
    public void confirmBooking(Long bookingId) {
        Booking booking = bookingRepository.findById(bookingId).orElse(null);
        if (booking != null) {
            booking.setStatus("CONFIRMED");
            bookingRepository.save(booking);
        }
    }

    // Method to cancel a booking
    public void cancelBooking(Long bookingId) {
        Booking booking = bookingRepository.findById(bookingId).orElse(null);
        if (booking != null) {
            booking.setStatus("CANCELED");
            bookingRepository.save(booking);
        }
    }

    // Retrieve bookings by user
    public List<Booking> getUserBookings(Long userId) {
        return bookingRepository.findByTouristId(userId);
    }
}
