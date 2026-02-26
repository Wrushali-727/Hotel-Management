package com.hotel.hotelmanagement.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "profile")
public class Profile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "phone_number") // MATCHING ER DIAGRAM
    private String phoneNumber;

    private String address;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;
}
