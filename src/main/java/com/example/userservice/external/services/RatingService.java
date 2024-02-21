package com.example.userservice.external.services;

import com.example.userservice.entities.Hotel;
import com.example.userservice.entities.Rating;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

@Service
@FeignClient(name = "rating-services")
public interface RatingService {

    @GetMapping("/ratings/user/{userId}")
    Rating getRatingsByUserId(@PathVariable int userId);

    @GetMapping("/ratings/hotels/{hotelId}")
    Hotel getHotel(int hotelid);

}
