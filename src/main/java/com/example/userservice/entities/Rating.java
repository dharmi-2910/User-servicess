package com.example.userservice.entities;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Rating {

    private int ratingid;
    private  int hotelid;
    private  int userid;
    private  String  rating;
    private  String feedback;

    private Hotel hotel;

}
