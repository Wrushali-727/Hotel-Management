package com.hotel.hotelmanagement.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import com.hotel.hotelmanagement.Entity.Hotel;

public interface HotelRepository extends JpaRepository<Hotel, Integer> {

    List<Hotel> findByRating(Integer rating);

}
