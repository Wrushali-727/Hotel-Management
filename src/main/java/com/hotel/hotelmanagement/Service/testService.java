package com.hotel.hotelmanagement.Service;

import com.hotel.hotelmanagement.DTO.HotelDetailDTO;
import lombok.Value;
import org.springframework.stereotype.Service;


//  if we dont write @Service here then it will give the following error
// Parameter 0 of constructor in com.mini.hotel.controller.TestController required a bean of type 'com.mini.hotel.service.TestService' that could not be found.
@Service
public class testService {

    private DummyService DummyService;

    public testService(DummyService dummyService){
        this.DummyService=dummyService;
    }


    public String create(HotelDetailDTO hotelDetails){
        System.out.println(DummyService.print());


        return " Hotel created successfully with name " + hotelDetails.getName() ; // this functions output is passed to testcontroller response entity
    }



}
