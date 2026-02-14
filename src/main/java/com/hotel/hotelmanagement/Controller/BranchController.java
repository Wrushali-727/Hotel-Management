package com.hotel.hotelmanagement.Controller;

import com.hotel.hotelmanagement.DTO.BranchDTO;
import com.hotel.hotelmanagement.Service.BranchService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/branches")
@RequiredArgsConstructor
public class BranchController {

    private final BranchService branchService;

    @PostMapping("/post")
    public BranchDTO createBranch(@RequestBody BranchDTO dto) {
        return branchService.createBranch(dto);
    }

    @GetMapping
    public List<BranchDTO> getAllBranches() {
        return branchService.getAllBranches();
    }

    @GetMapping("/hotel/{hotelId}")
    public List<BranchDTO> getBranchesByHotel(@PathVariable Long hotelId) {
        return branchService.getBranchesByHotel(hotelId);
    }


}
