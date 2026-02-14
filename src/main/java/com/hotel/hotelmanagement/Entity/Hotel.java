package com.hotel.hotelmanagement.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "hotels")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Hotel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long hotelId;

    private String hotelName;
    private String city;
    private String address;
    private String contactNumber;
    private String email;

    @OneToMany(mappedBy = "hotel", cascade = CascadeType.ALL)
    private List<Branch> branches;
}

