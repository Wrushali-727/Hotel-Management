package com.hotel.hotelmanagement.Controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import java.util.List;

import com.hotel.hotelmanagement.Service.RoomService;
import com.hotel.hotelmanagement.DTO.RoomDTO;

@RestController
@RequestMapping("/room")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class RoomController {

    private final RoomService roomService;

    @PostMapping
    public ResponseEntity<String> createRoom(@RequestBody RoomDTO dto) {
        // We'll update the service to use hotelId from DTO
        roomService.createRoom(dto.getHotelId() != null ? dto.getHotelId() : 1L, dto);
        return ResponseEntity.ok("Room created successfully");
    }

    @GetMapping
    public ResponseEntity<List<RoomDTO>> getAllRooms() {
        return ResponseEntity.ok(roomService.getAllRooms());
    }
}