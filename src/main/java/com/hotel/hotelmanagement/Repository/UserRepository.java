package com.hotel.hotelmanagement.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.hotel.hotelmanagement.Entity.User;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
}