package com.example.userservice.external.services;

import com.example.userservice.entities.Hotel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "hotel-services")
public interface HotelServices {
    @GetMapping("/hotels/{hotelid}")
    Hotel getHotel(int hotelid);
}

