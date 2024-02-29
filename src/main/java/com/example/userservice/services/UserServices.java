package com.example.userservice.services;

import com.example.userservice.entities.User;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public  interface UserServices {
     User saveUser(User user);
    List<User> getAllUser();
    User getUser(int userId);
}

