package com.hotel.hotelmanagement.Service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import com.hotel.hotelmanagement.Repository.*;
import com.hotel.hotelmanagement.Entity.*;
import com.hotel.hotelmanagement.DTO.RoomDTO;

@Service
@RequiredArgsConstructor
public class RoomService {

    private final RoomRepository roomRepository;
    private final HotelRepository hotelRepository;

    // Create Room using DTO
    public void createRoom(Long hotelId, RoomDTO dto) {

        Hotel hotel = hotelRepository.findById(hotelId)
                .orElseThrow(() -> new RuntimeException("Hotel not found with id: " + hotelId));

        Room room = new Room();
        room.setRoomNumber(dto.getRoomNumber());
        room.setType(dto.getType());
        room.setPrice(dto.getPrice());
        room.setAvailableCount(dto.getAvailableCount());
        room.setHotel(hotel);

        roomRepository.save(room);
    }

    // Get all rooms as DTO
    public List<RoomDTO> getAllRooms() {

        return roomRepository.findAll()
                .stream()
                .map(room -> mapToDTO(room))
                .collect(Collectors.toList());
    }

    // 🔥 Clean Mapping Method (Best Practice)
    private RoomDTO mapToDTO(Room room) {

        RoomDTO dto = new RoomDTO();
        dto.setId(room.getId());                 // Must be Long
        dto.setRoomNumber(room.getRoomNumber());
        dto.setType(room.getType());
        dto.setPrice(room.getPrice());
        dto.setAvailableCount(room.getAvailableCount());

        if (room.getHotel() != null) {
            dto.setHotelId(room.getHotel().getId());  // Must be Long
        }

        return dto;
    }
}