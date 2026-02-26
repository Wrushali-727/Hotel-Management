package com.hotel.hotelmanagement.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.hotel.hotelmanagement.Entity.Booking;
import java.util.List;

public interface BookingRepository extends JpaRepository<Booking, Long> {

    // Fixed nested property
    List<Booking> findByUser_Id(Long userId);
}