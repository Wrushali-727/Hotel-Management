package com.hotel.hotelmanagement.Controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import com.hotel.hotelmanagement.Service.HotelService;
import com.hotel.hotelmanagement.DTO.HotelDetailDTO;
import com.hotel.hotelmanagement.Entity.Hotel;

import java.util.List;

@RestController
@RequestMapping("/hotel")
@RequiredArgsConstructor
public class HotelController {

    private final HotelService hotelService;

    // CREATE HOTEL
    @PostMapping("/create")
    public ResponseEntity<String> create(@RequestBody HotelDetailDTO dto) {
        return ResponseEntity.ok(hotelService.create(dto));
    }

    //GET ALL HOTELS
    @GetMapping("/all")
    public ResponseEntity<List<Hotel>> getAllHotels() {
        return ResponseEntity.ok(hotelService.getAllHotels());
    }

    //GET HOTEL BY ID
    @GetMapping("/{id}")
    public ResponseEntity<Hotel> getHotel(@PathVariable Integer id) {
        return ResponseEntity.ok(hotelService.getHotelById(id));
    }

    //GET HOTEL BY RATING
    @GetMapping("/rating/{rating}")
    public ResponseEntity<List<Hotel>> getHotelByRating(@PathVariable Integer rating) {
        return ResponseEntity.ok(hotelService.getHotelByRating(rating));
    }
}
