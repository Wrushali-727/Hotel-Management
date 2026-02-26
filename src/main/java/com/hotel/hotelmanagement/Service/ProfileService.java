package com.hotel.hotelmanagement.Service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.hotel.hotelmanagement.Entity.Profile;
import com.hotel.hotelmanagement.Entity.User;
import com.hotel.hotelmanagement.DTO.ProfileDTO;
import com.hotel.hotelmanagement.Repository.ProfileRepository;
import com.hotel.hotelmanagement.Repository.UserRepository;

@Service
@RequiredArgsConstructor
public class ProfileService {

    private final ProfileRepository profileRepository;
    private final UserRepository userRepository;

    public Profile saveOrUpdate(ProfileDTO dto) {
        User user = userRepository.findById(dto.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        Profile profile = profileRepository.findByUserId(dto.getUserId())
                .orElse(new Profile());

        profile.setPhoneNumber(dto.getPhoneNumber());
        profile.setAddress(dto.getAddress());
        profile.setUser(user);

        return profileRepository.save(profile);
    }

    public Profile getByUserId(Long userId) {
        return profileRepository.findByUserId(userId)
                .orElseThrow(() -> new RuntimeException("Profile not found"));
    }
}
