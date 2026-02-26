package com.hotel.hotelmanagement.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProfileDTO {
    private Long id;
    private String phoneNumber;
    private String address;
    private Long userId;
}
