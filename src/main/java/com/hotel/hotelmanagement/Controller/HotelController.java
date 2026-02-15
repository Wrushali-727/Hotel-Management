package com.hotel.hotelmanagement.Controller;

import com.hotel.hotelmanagement.DTO.HotelDetailDTO;
import com.hotel.hotelmanagement.Service.HotelService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hotel")
public class HotelController {

    private final HotelService hotelService;

    public HotelController(HotelService hotelService){
        this.hotelService = hotelService;
    }

    @PostMapping("/create")
    public ResponseEntity<String> create(@RequestBody HotelDetailDTO hotelDetailsDTO ){
        String response = hotelService.create(hotelDetailsDTO);
        return ResponseEntity.ok(response);
    }
}

