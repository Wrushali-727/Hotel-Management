package com.hotel.hotelmanagement.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import com.hotel.hotelmanagement.Entity.Room;

public interface RoomRepository extends JpaRepository<Room, Long> {

    List<Room> findByAvailableCountGreaterThan(Integer count);

}
