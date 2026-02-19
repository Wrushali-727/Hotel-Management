package com.hotel.hotelmanagement.Service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

import com.hotel.hotelmanagement.Repository.*;
import com.hotel.hotelmanagement.Entity.*;
import com.hotel.hotelmanagement.DTO.BookingDTO;

@Service
@RequiredArgsConstructor
@Transactional
public class BookingService {

    private final BookingRepository bookingRepository;
    private final RoomRepository roomRepository;
    private final UserRepository userRepository;

    //BOOK ROOM
    public String bookRoom(BookingDTO dto) {

        Room room = roomRepository.findById(dto.getRoomId())
                .orElseThrow(() -> new RuntimeException("Room not found"));

        if (room.getAvailableCount() <= 0) {
            return "Room Not Available";
        }

        User user = userRepository.findById(dto.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        room.setAvailableCount(room.getAvailableCount() - 1);

        Booking booking = new Booking();
        booking.setBookingDate(LocalDate.now());
        booking.setCheckInDate(dto.getCheckInDate());
        booking.setCheckOutDate(dto.getCheckOutDate());
        booking.setRoom(room);
        booking.setUser(user);

        bookingRepository.save(booking);

        return "Room Booked Successfully";
    }

    // GET BOOKINGS BY USER
    public List<Booking> getBookingsByUser(Long userId) {
        return bookingRepository.findByUserId(userId);
    }
}

