package com.hotel.hotelmanagement.Service;

import com.hotel.hotelmanagement.DTO.BranchDTO;
import com.hotel.hotelmanagement.Entity.Branch;
import com.hotel.hotelmanagement.Entity.Hotel;
import com.hotel.hotelmanagement.Repository.BranchRepository;
import com.hotel.hotelmanagement.Repository.HotelRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BranchService {

    private final BranchRepository branchRepository;
    private final HotelRepository hotelRepository;

    // CREATE
    public BranchDTO createBranch(BranchDTO dto) {

        Hotel hotel = hotelRepository.findById(dto.getHotelId())
                .orElseThrow(() -> new RuntimeException("Hotel not found"));

        Branch branch = new Branch();
        branch.setBranchName(dto.getBranchName());
        branch.setBranchLocation(dto.getBranchLocation());
        branch.setContactNumber(dto.getContactNumber());
        branch.setHotel(hotel);

        Branch savedBranch = branchRepository.save(branch);

        return mapToDTO(savedBranch);
    }

    // GET ALL
    public List<BranchDTO> getAllBranches() {
        return branchRepository.findAll()
                .stream()
                .map(this::mapToDTO)
                .toList();
    }

    // GET BY HOTEL ID
    public List<BranchDTO> getBranchesByHotel(Long hotelId) {

        return branchRepository.findByHotel_HotelId(hotelId)
                .stream()
                .map(this::mapToDTO)
                .toList();
    }

    // DELETE
    public void deleteBranch(Long id) {
        branchRepository.deleteById(id);
    }

    // Convert Entity → DTO
    private BranchDTO mapToDTO(Branch branch) {
        return new BranchDTO(
                branch.getBranchId(),
                branch.getBranchName(),
                branch.getBranchLocation(),
                branch.getContactNumber(),
                branch.getHotel().getHotelId()
        );
    }
}
