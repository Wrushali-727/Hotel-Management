package com.hotel.hotelmanagement.Controller;

import com.hotel.hotelmanagement.DTO.HotelDTO;
import com.hotel.hotelmanagement.Service.HotelService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/hotels")
@RequiredArgsConstructor
public class HotelController {

    private final HotelService hotelService;

    // ✅ CREATE HOTEL
    @PostMapping
    public HotelDTO createHotel(@RequestBody HotelDTO hotelDTO) {
        return hotelService.createHotel(hotelDTO);
    }

    // ✅ GET ALL HOTELS
    @GetMapping
    public List<HotelDTO> getAllHotels() {
        return hotelService.getAllHotels();
    }

    // ✅ GET HOTEL BY ID
    @GetMapping("/{id}")
    public HotelDTO getHotelById(@PathVariable Long id) {
        return hotelService.getHotelById(id);
    }

    // ✅ UPDATE HOTEL
    @PutMapping("/{id}")
    public HotelDTO updateHotel(@PathVariable Long id,
                                @RequestBody HotelDTO hotelDTO) {
        return hotelService.updateHotel(id, hotelDTO);
    }


}
