package com.hotel.hotelmanagement.Controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.hotel.hotelmanagement.Entity.Profile;
import com.hotel.hotelmanagement.DTO.ProfileDTO;
import com.hotel.hotelmanagement.Service.ProfileService;

@RestController
@RequestMapping("/profile")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class ProfileController {

    private final ProfileService profileService;

    @PostMapping
    public ResponseEntity<Profile> saveOrUpdate(@RequestBody ProfileDTO dto) {
        return ResponseEntity.ok(profileService.saveOrUpdate(dto));
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<Profile> getByUserId(@PathVariable Long userId) {
        return ResponseEntity.ok(profileService.getByUserId(userId));
    }
}
