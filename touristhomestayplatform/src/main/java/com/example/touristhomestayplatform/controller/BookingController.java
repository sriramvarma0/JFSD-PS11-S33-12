package com.example.touristhomestayplatform.controller;

import com.example.touristhomestayplatform.dto.BookingDTO;
import com.example.touristhomestayplatform.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/bookings")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    // Display booking form
    @GetMapping("/book/{homestayId}")
    public String showBookingForm(@PathVariable Long homestayId, Model model) {
        model.addAttribute("homestayId", homestayId);
        return "booking";
    }

    // Handle booking confirmation
    @PostMapping("/confirm")
    public String confirmBooking(@ModelAttribute BookingDTO bookingDTO) {
        bookingService.bookHomestay(bookingDTO);
        return "redirect:/homestays";
    }

    // Confirm booking by admin
    @PostMapping("/confirm/{bookingId}")
    public String confirmBooking(@PathVariable Long bookingId) {
        bookingService.confirmBooking(bookingId);
        return "redirect:/admin/dashboard";
    }

    // Cancel booking by admin
    @PostMapping("/cancel/{bookingId}")
    public String cancelBooking(@PathVariable Long bookingId) {
        bookingService.cancelBooking(bookingId);
        return "redirect:/admin/dashboard";
    }
}
