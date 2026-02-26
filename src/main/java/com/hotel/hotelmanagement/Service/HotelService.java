package com.hotel.hotelmanagement.Service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

import com.hotel.hotelmanagement.Entity.*;
import com.hotel.hotelmanagement.DTO.*;
import com.hotel.hotelmanagement.Repository.*;

@Service
@RequiredArgsConstructor
public class HotelService {

    private final HotelRepository hotelRepository;

    public void create(HotelDetailDTO dto) {

        Hotel hotel = new Hotel();
        hotel.setName(dto.getName());
        hotel.setCity(dto.getCity()); // ✅ ADDED AS PER ER DIAGRAM
        hotel.setImageUrl(dto.getImageUrl());
        hotel.setRating(dto.getRating());

        hotelRepository.save(hotel);
    }

    public List<Hotel> getAllHotels() {
        return hotelRepository.findAll();
    }
}