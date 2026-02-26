package com.hotel.hotelmanagement.Controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import java.util.List;

import com.hotel.hotelmanagement.Service.HotelService;
import com.hotel.hotelmanagement.DTO.HotelDetailDTO;
import com.hotel.hotelmanagement.Entity.Hotel;

@RestController
@RequestMapping("/hotel")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class HotelController {

    private final HotelService hotelService;

    @PostMapping
    public ResponseEntity<String> create(@RequestBody HotelDetailDTO dto) {
        hotelService.create(dto);
        return ResponseEntity.ok("Hotel created successfully");
    }

    @GetMapping
    public ResponseEntity<List<Hotel>> getAll() {
        return ResponseEntity.ok(hotelService.getAllHotels());
    }
}