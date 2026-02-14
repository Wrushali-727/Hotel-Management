package com.hotel.hotelmanagement.Repository;

import com.hotel.hotelmanagement.Entity.Branch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BranchRepository extends JpaRepository<Branch, Long> {

    List<Branch> findByHotel_HotelId(Long hotelId);
}
