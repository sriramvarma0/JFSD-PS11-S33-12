package com.example.touristhomestayplatform.controller;

import com.example.touristhomestayplatform.model.Homestay;
import com.example.touristhomestayplatform.service.HomestayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/homestays")
public class HomestayController {
    @Autowired
    private HomestayService homestayService;

    @GetMapping
    public List<Homestay> getAllHomestays() {
        return homestayService.getAllHomestays();
    }
}
