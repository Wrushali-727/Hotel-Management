package com.hotel.hotelmanagement.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RoomDTO {

    private Long id;
    private String roomNumber;
    private String type;
    private Double price;
    private Integer availableCount;
    private Integer hotelId;
}