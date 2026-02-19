package com.hotel.hotelmanagement.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String roomNumber;
    private String type;
    private Double price;
    private Integer availableCount;

    @ManyToOne
    @JoinColumn(name = "hotel_id")
    private Hotel hotel;
}
