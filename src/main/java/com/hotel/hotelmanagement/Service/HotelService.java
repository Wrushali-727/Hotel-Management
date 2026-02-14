package com.hotel.hotelmanagement.Service;

import com.hotel.hotelmanagement.DTO.HotelDTO;
import com.hotel.hotelmanagement.Entity.Hotel;
import com.hotel.hotelmanagement.Repository.HotelRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class HotelService {

    private final HotelRepository hotelRepository;

    // CREATE
    public HotelDTO createHotel(HotelDTO dto) {

        Hotel hotel = new Hotel();
        hotel.setHotelName(dto.getHotelName());
        hotel.setCity(dto.getCity());
        hotel.setAddress(dto.getAddress());
        hotel.setContactNumber(dto.getContactNumber());
        hotel.setEmail(dto.getEmail());

        Hotel savedHotel = hotelRepository.save(hotel);

        return mapToDTO(savedHotel);
    }

    // GET ALL
    public List<HotelDTO> getAllHotels() {
        return hotelRepository.findAll()
                .stream()
                .map(this::mapToDTO)
                .toList();
    }

    // GET BY ID
    public HotelDTO getHotelById(Long id) {

        Hotel hotel = hotelRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Hotel not found"));

        return mapToDTO(hotel);
    }

    // UPDATE
    public HotelDTO updateHotel(Long id, HotelDTO dto) {

        Hotel hotel = hotelRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Hotel not found"));

        hotel.setHotelName(dto.getHotelName());
        hotel.setCity(dto.getCity());
        hotel.setAddress(dto.getAddress());
        hotel.setContactNumber(dto.getContactNumber());
        hotel.setEmail(dto.getEmail());

        Hotel updatedHotel = hotelRepository.save(hotel);

        return mapToDTO(updatedHotel);
    }

    // DELETE
    public void deleteHotel(Long id) {
        hotelRepository.deleteById(id);
    }

    // Convert Entity → DTO
    private HotelDTO mapToDTO(Hotel hotel) {
        return new HotelDTO(
                hotel.getHotelId(),
                hotel.getHotelName(),
                hotel.getCity(),
                hotel.getAddress(),
                hotel.getContactNumber(),
                hotel.getEmail()
        );
    }
}
