package com.hotel.hotelmanagement.Service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import com.hotel.hotelmanagement.Entity.Hotel;
import com.hotel.hotelmanagement.Entity.Branch;
import com.hotel.hotelmanagement.DTO.BranchDTO;
import com.hotel.hotelmanagement.DTO.HotelDetailDTO;
import com.hotel.hotelmanagement.Repository.HotelRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class HotelService {

    private final HotelRepository hotelRepository;

    //CREATE HOTEL
    public String create(HotelDetailDTO hotelDetailsDTO) {

        Hotel hotel = new Hotel();
        hotel.setName(hotelDetailsDTO.getName());
        hotel.setImageUrl(hotelDetailsDTO.getImageUrl());
        hotel.setRating(hotelDetailsDTO.getRating());

        for (BranchDTO branchDTO : hotelDetailsDTO.getBranches()) {

            Branch branch = new Branch();
            branch.setName(branchDTO.getBranchName());
            branch.setAddress(branchDTO.getBranchLocation());
            branch.setRating(branchDTO.getRating());
            branch.setHotel(hotel);

            hotel.getHotelBranches().add(branch);
        }

        hotelRepository.save(hotel);

        return "New hotel created";
    }

    // GET ALL HOTELS
    public List<Hotel> getAllHotels() {
        return hotelRepository.findAll();
    }

    // GET HOTEL BY ID
    public Hotel getHotelById(Integer id) {
        return hotelRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Hotel not found"));
    }

    // GET HOTEL BY RATING (ADDED PROPERLY)
    public List<Hotel> getHotelByRating(Integer rating) {
        return hotelRepository.findByRating(rating);
    }
}
