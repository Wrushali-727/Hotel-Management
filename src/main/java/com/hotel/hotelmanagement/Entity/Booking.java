package com.hotel.hotelmanagement.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;

@Getter
@Setter
@Entity
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate bookingDate;
    private LocalDate checkInDate;
    private LocalDate checkOutDate;

    @ManyToOne
    private Room room;

    @ManyToOne
    private User user;
}
