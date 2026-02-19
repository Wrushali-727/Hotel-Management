package com.hotel.hotelmanagement.Service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import com.hotel.hotelmanagement.Repository.RoomRepository;
import com.hotel.hotelmanagement.Repository.HotelRepository;
import com.hotel.hotelmanagement.Entity.Room;
import com.hotel.hotelmanagement.Entity.Hotel;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RoomService {

    private final RoomRepository roomRepository;
    private final HotelRepository hotelRepository;

    // CREATE ROOM
    public String createRoom(Integer hotelId, Room room) {

        Hotel hotel = hotelRepository.findById(hotelId)
                .orElseThrow(() -> new RuntimeException("Hotel not found"));

        room.setHotel(hotel);
        roomRepository.save(room);

        return "Room created successfully";
    }

    // GET ALL ROOMS
    public List<Room> getAllRooms() {
        return roomRepository.findAll();
    }

    // GET ROOM BY ID
    public Room getRoomById(Long id) {
        return roomRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Room not found"));
    }

    // DELETE ROOM
    public String deleteRoom(Long id) {

        if (!roomRepository.existsById(id)) {
            throw new RuntimeException("Room not found");
        }

        roomRepository.deleteById(id);
        return "Room deleted successfully";
    }

    // NEW METHOD: GET AVAILABLE ROOMS
    public List<Room> getAvailableRooms() {
        return roomRepository.findByAvailableCountGreaterThan(0);
    }
}
