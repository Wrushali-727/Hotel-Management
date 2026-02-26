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

    // CUSTOMER only booking
    public void bookRoom(BookingDTO dto) {

        User user = userRepository.findById(dto.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (!user.getRole().getName().equals("CUSTOMER")) {
            throw new RuntimeException("Only customers can book rooms");
        }

        if (dto.getCheckOutDate().isBefore(dto.getCheckInDate())) {
            throw new RuntimeException("Invalid booking dates");
        }

        Room room = roomRepository.findById(dto.getRoomId())
                .orElseThrow(() -> new RuntimeException("Room not found"));

        if (room.getAvailableCount() <= 0) {
            throw new RuntimeException("Room not available");
        }

        room.setAvailableCount(room.getAvailableCount() - 1);

        Booking booking = new Booking();
        booking.setBookingDate(LocalDate.now());
        booking.setCheckInDate(dto.getCheckInDate());
        booking.setCheckOutDate(dto.getCheckOutDate());
        booking.setStatus(Booking.BookingStatus.CONFIRMED);
        booking.setRoom(room);
        booking.setUser(user);
        booking.setNumberOfRooms(dto.getNumberOfRooms());
        booking.setSpecialRequest(dto.getSpecialRequest());

        bookingRepository.save(booking);
    }

    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }

    public void cancelBooking(Long bookingId) {

        Booking booking = bookingRepository.findById(bookingId)
                .orElseThrow(() -> new RuntimeException("Booking not found"));

        booking.setStatus(Booking.BookingStatus.CANCELLED);

        Room room = booking.getRoom();
        room.setAvailableCount(room.getAvailableCount() + 1);
    }

    public List<Booking> getBookingsByUser(Long userId) {
        return bookingRepository.findByUser_Id(userId);
    }
}
