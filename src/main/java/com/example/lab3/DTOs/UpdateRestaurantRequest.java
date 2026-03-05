package com.example.lab3.DTOs;
import lombok.Data;

@Data
public class UpdateRestaurantRequest {
    private Long locationId;   // required so we can ensure restaurant is in that location
    private String name;
    private String phone;
}

