package com.example.touristhomestayplatform.repository;

import com.example.touristhomestayplatform.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {
    List<Booking> findByTouristId(Long userId);
}
