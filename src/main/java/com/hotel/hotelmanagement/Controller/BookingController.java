package com.hotel.hotelmanagement.Controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import com.hotel.hotelmanagement.Service.BookingService;
import com.hotel.hotelmanagement.DTO.BookingDTO;
import com.hotel.hotelmanagement.Entity.Booking;

import java.util.List;

@RestController
@RequestMapping("/booking")
@RequiredArgsConstructor
public class BookingController {

    private final BookingService bookingService;

    @PostMapping("/create")
    public ResponseEntity<String> book(@RequestBody BookingDTO dto) {
        return ResponseEntity.ok(bookingService.bookRoom(dto));
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Booking>> getBookingsByUser(@PathVariable Long userId) {
        return ResponseEntity.ok(bookingService.getBookingsByUser(userId));
    }
}
