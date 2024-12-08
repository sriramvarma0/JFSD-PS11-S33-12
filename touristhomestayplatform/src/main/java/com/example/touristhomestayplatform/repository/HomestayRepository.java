package com.example.touristhomestayplatform.repository;

import com.example.touristhomestayplatform.model.Homestay;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface HomestayRepository extends JpaRepository<Homestay, Long> {
    List<Homestay> findByLocation(String location);
}
