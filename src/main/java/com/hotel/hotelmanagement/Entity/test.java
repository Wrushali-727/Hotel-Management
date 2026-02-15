package com.hotel.hotelmanagement.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class test {
    @Id
    private Integer id;
    private Integer name;
}