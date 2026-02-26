package com.hotel.hotelmanagement.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDTO {

    private String fullName;
    private String email;
    private String password;
    private String role;   // optional (ADMIN or CUSTOMER)
}