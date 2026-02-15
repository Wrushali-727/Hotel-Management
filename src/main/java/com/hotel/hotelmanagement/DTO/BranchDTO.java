package com.hotel.hotelmanagement.DTO;

import lombok.Data;

@Data
public class BranchDTO {

    private Long branchId;
    private String branchName;
    private String branchLocation;
    private String contactNumber;
    private Long hotelId;
    private Integer rating;
}

