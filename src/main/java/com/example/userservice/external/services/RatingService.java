package com.example.userservice.external.services;

import com.example.userservice.entities.Hotel;
import com.example.userservice.entities.Rating;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Service
@FeignClient(name="RATING-SERVICE")
public interface RatingService {

    @GetMapping("/ratings/user/{userId}")
    List<Rating> getRatingsByUserId(@PathVariable int userId);

    @PostMapping("/ratings")
    public Rating createRating(Rating values);

    @PutMapping("/ratings/{id}")
    public Rating updateRating(@PathVariable("id")int id, Rating rating);

    @DeleteMapping("/ratings/{id}")
    public void deleteRating(@PathVariable int id);

    Hotel getHotel(int hotelId);
}
