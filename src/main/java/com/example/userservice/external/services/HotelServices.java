package com.example.userservice.external.services;

import com.example.userservice.entities.Hotel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Service
@FeignClient(name = "HOTEL-SERVICE")
public interface HotelServices {

    @GetMapping("/hotels/{hotelid}")
    Hotel getHotel(@PathVariable int hotelid);
}
