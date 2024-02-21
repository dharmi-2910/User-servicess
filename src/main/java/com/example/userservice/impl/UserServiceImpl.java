package com.example.userservice.impl;

import com.example.userservice.entities.Hotel;
import com.example.userservice.entities.Rating;
import com.example.userservice.entities.User;
import com.example.userservice.external.services.HotelServices;
import com.example.userservice.external.services.RatingService;
import com.example.userservice.repositories.UserRepository;
import com.example.userservice.services.UserServices;
import feign.FeignException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserServices {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private HotelServices hotelServices;
    @Autowired
    private RatingService ratingFeignClient;

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    @Override
    public User getUser(int userId) {
        User user = userRepository.findById(userId).orElseThrow(() ->
                new RuntimeException("User with id not found in the server!! " + userId));

        try {
            List<Rating> ratings = (List<Rating>) ratingFeignClient.getRatingsByUserId(user.getId());

            List<Rating> ratingList = ratings.stream().map(rating -> {
                Hotel hotel = ratingFeignClient.getHotel(rating.getHotelid());
                rating.setHotel(hotel);
                return rating;
            }).collect(Collectors.toList());

            user.setRatings(ratingList);
        } catch (FeignException ex) {
           ex.getMessage();
        }
        return user;
    }


//        @Override
//    public User getUser(int userId) {
//        User user = userRepository.findById(userId).orElseThrow(() ->
//                new RuntimeException("User with id not found in the server!! " + userId));
//
//        Rating[] RatingsOfUser = restTemplate.getForObject("http://RATING-SERVICE/ratings/users/" + user.getId(), Rating[].class);
//        logger.info("Ratings: {}", RatingsOfUser);
//
//        List<Rating> ratings = Arrays.stream(RatingsOfUser).toList();
//
//        List<Rating> ratingList = ratings.stream().map(rating -> {
////            ResponseEntity<Hotel> forEntity = restTemplate.getForEntity("http://USER-SERVICES/users/" + rating.getHotelId(), Hotel.class);
//            Hotel hotel = hotelServices.getHotel(rating.getHotelid());
////            logger.info("Response status code: {}", forEntity.getStatusCode());
//            rating.setHotel(hotel);
//            return rating;
//        }).collect(Collectors.toList());
//
//        user.setRatings(ratingList);
//        return user;
//    }
}
