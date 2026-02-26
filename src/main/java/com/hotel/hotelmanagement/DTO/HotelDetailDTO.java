package com.hotel.hotelmanagement.DTO;

import lombok.Data;
import java.util.List;

@Data
public class HotelDetailDTO {
    private String name;
    private String city;
    private String imageUrl;
    private Integer rating;
}
