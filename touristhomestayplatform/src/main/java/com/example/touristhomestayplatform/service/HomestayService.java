package com.example.touristhomestayplatform.service;

import com.example.touristhomestayplatform.model.Homestay;
import com.example.touristhomestayplatform.repository.HomestayRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HomestayService {
    @Autowired
    private HomestayRepository homestayRepository;

    public List<Homestay> getAllHomestays() {
        return homestayRepository.findAll();
    }

    public List<Homestay> searchByLocation(String location) {
        return homestayRepository.findByLocation(location);
    }
}
