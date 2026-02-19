package com.hotel.hotelmanagement.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Data
@Entity
@Table(name = "hotel")
public class Hotel {

    @Id
    @SequenceGenerator(name = "hotel_id_seq", sequenceName = "seq_hotel_id", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "hotel_id_seq")
    private Integer id;

    private String name;
    private String imageUrl;
    private Integer rating;

    @OneToMany(mappedBy = "hotel", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Branch> hotelBranches = new ArrayList<>();
}

