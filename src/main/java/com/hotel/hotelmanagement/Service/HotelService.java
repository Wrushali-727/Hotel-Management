package com.hotel.hotelmanagement.Service;

import com.hotel.hotelmanagement.Entity.Hotel;
import com.hotel.hotelmanagement.Entity.Branch;
import com.hotel.hotelmanagement.DTO.BranchDTO;
import com.hotel.hotelmanagement.DTO.HotelDetailDTO;
import com.hotel.hotelmanagement.Repository.BranchRepository;
import com.hotel.hotelmanagement.Repository.HotelRepository;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;


@Service
public class HotelService {


    private final HotelRepository hotelRepository;


    public HotelService(HotelRepository hotelRepository /*, HotelBranchRepository BranchRepository */ ) {
        this.hotelRepository = hotelRepository;

    }

    public String create (HotelDetailDTO hotelDetailsDTO){

        System.out.println(hotelDetailsDTO);

        Hotel hotel = new Hotel();

        hotel.setName(hotelDetailsDTO.getName());
        hotel.setImageUrl(hotelDetailsDTO.getImageUrl());
        hotel.setRating(hotelDetailsDTO.getRating());


        Hotel savedHotel = hotelRepository.save(hotel);



        for (BranchDTO branchDTO : hotelDetailsDTO.getBranches()) {

            Branch branch = new Branch();

            branch.setName(branchDTO.getBranchName());           // name → branchName
            branch.setAddress(branchDTO.getBranchLocation());
            branch.setRating(branchDTO.getRating());
            branch.setHotel(hotel);
            hotel.getHotelBranches().add(branch);

        }

        return "new hotel created " ;
    }

}