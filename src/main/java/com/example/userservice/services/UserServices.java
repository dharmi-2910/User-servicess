package com.example.userservice.services;

import com.example.userservice.UserServiceApplication;
import com.example.userservice.entities.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public  interface UserServices {
     Logger logger = LoggerFactory.getLogger(UserServiceApplication.class);
     User saveUser(User user);
    List<User> getAllUser();
    User getUser(int userId);
}

