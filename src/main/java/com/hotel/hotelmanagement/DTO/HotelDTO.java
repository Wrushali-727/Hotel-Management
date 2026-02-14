package com.hotel.hotelmanagement.DTO;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class HotelDTO {

    private Long hotelId;
    private String hotelName;
    private String city;
    private String address;
    private String contactNumber;
    private String email;
}
