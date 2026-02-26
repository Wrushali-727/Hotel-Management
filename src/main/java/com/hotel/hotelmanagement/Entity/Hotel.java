package com.hotel.hotelmanagement.Entity;

import jakarta.persistence.*;
import lombok.Data;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Hotel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private String city; // ADDED AS PER ER DIAGRAM
    private String imageUrl;
    private Integer rating;

    @OneToMany(mappedBy = "hotel", cascade = CascadeType.ALL)
    private List<Room> rooms = new ArrayList<>(); // UPDATED RELATIONSHIP AS PER ER DIAGRAM
}