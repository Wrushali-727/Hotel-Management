package com.hotel.hotelmanagement.Service;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.hotel.hotelmanagement.Repository.UserRepository;
import com.hotel.hotelmanagement.Repository.RoleRepository;
import com.hotel.hotelmanagement.DTO.RegisterRequestDTO;
import com.hotel.hotelmanagement.Entity.User;
import com.hotel.hotelmanagement.Entity.Role;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    // AUTO CREATE ROLES WHEN STARTS
    @PostConstruct
    public void initRoles() {
        if (roleRepository.findByName("USER").isEmpty()) {
            Role userRole = new Role();
            userRole.setName("USER");
            roleRepository.save(userRole);
        }

        if (roleRepository.findByName("ADMIN").isEmpty()) {
            Role adminRole = new Role();
            adminRole.setName("ADMIN");
            roleRepository.save(adminRole);
        }
    }

    // REGISTER
    public String register(RegisterRequestDTO dto) {

        Role role = roleRepository.findByName("USER")
                .orElseThrow(() -> new RuntimeException("Role not found"));

        User user = new User();
        user.setFullName(dto.getFullName());
        user.setEmail(dto.getEmail());
        user.setPassword(dto.getPassword());
        user.setRole(role);

        userRepository.save(user);

        return "User Registered Successfully";
    }

    // GET USER
    public RegisterRequestDTO getUser(Long id) {

        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));

        RegisterRequestDTO dto = new RegisterRequestDTO();
        dto.setFullName(user.getFullName());
        dto.setEmail(user.getEmail());
        dto.setPassword(user.getPassword());

        return dto;
    }

    // UPDATE USER
    public String updateUser(Long id, RegisterRequestDTO dto) {

        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));

        user.setFullName(dto.getFullName());
        user.setEmail(dto.getEmail());
        user.setPassword(dto.getPassword());

        userRepository.save(user);

        return "User updated successfully";
    }
}
