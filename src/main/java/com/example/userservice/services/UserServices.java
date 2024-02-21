package com.example.userservice.services;

import com.example.userservice.entities.User;
import com.example.userservice.external.services.RatingService;

import java.util.List;

public  interface UserServices {
     User saveUser(User user);
    List<User> getAllUser();
     User getUser(int userId, RatingService hotelService);
}

