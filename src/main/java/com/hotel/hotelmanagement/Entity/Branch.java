package com.hotel.hotelmanagement.Entity;

import jakarta.persistence.*;
import lombok.Data;
import com.fasterxml.jackson.annotation.JsonBackReference;

@Data
@Entity
@Table(name = "hotel_branch")
public class Branch {

    @Id
    @SequenceGenerator(
            name = "hotel_branch_seq_id",
            sequenceName = "seq_hotel_branch_id",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "hotel_branch_seq_id"
    )
    private Integer id;

    private String name;
    private String address;
    private Integer rating;

    @ManyToOne
    @JoinColumn(name = "hotel_id")
    @JsonBackReference
    private Hotel hotel;
}
