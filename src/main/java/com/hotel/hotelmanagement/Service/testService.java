package com.hotel.hotelmanagement.Service;

import com.hotel.hotelmanagement.DTO.HotelDetailDTO;
import lombok.Value;
import org.springframework.stereotype.Service;

@Service
public class testService {

    private DummyService DummyService;

    public testService(DummyService dummyService){

        this.DummyService=dummyService;
    }


    public String create(HotelDetailDTO hotelDetails){
        System.out.println(DummyService.print());


        return " Hotel created successfully with name " + hotelDetails.getName() ;
    }



}
