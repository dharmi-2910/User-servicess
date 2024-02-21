package com.example.userservice.external.services;

import com.example.userservice.entities.Rating;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Service
@FeignClient(name = "RATING-SERVICES")
public interface RatingService {
    @GetMapping("/ratings/users/{userId}")
    List<Rating> getRatingsByUserId(@PathVariable("userId") int userId);
}
