package com.hotel.hotelmanagement.DTO;

import lombok.Data; // this will automata

import java.util.List;



@Data
public class HotelDetailDTO {




    private String name;
    private String imageUrl;
    private Integer rating;
    private List<BranchDTO> branches;


}




