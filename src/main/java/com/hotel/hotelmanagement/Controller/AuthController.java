package com.hotel.hotelmanagement.Controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import com.hotel.hotelmanagement.Service.AuthService;
import com.hotel.hotelmanagement.DTO.RegisterRequestDTO;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody RegisterRequestDTO dto) {
        return ResponseEntity.ok(authService.register(dto));
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<?> getUser(@PathVariable Long id) {
        return ResponseEntity.ok(authService.getUser(id));
    }

    @PutMapping("/user/{id}")
    public ResponseEntity<String> updateUser(
            @PathVariable Long id,
            @RequestBody RegisterRequestDTO dto) {

        return ResponseEntity.ok(authService.updateUser(id, dto));
    }
}



