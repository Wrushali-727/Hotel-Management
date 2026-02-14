package com.hotel.hotelmanagement.DTO;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BranchDTO {

    private Long branchId;
    private String branchName;
    private String branchLocation;
    private String contactNumber;
    private Long hotelId;
}

