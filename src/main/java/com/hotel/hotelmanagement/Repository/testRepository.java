package com.hotel.hotelmanagement.Repository;


import com.hotel.hotelmanagement.Entity.test;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


    @Repository
    public interface testRepository extends JpaRepository<test,Integer> {


    }

