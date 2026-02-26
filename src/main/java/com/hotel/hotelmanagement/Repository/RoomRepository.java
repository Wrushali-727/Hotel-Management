package com.hotel.hotelmanagement.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.hotel.hotelmanagement.Entity.Room;
import java.util.List;

public interface RoomRepository extends JpaRepository<Room, Long> {
    List<Room> findByAvailableCountGreaterThan(Integer count);
}
