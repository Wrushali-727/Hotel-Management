package com.hotel.hotelmanagement.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.hotel.hotelmanagement.Entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
}

