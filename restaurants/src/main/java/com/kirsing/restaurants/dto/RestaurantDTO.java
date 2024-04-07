package com.kirsing.restaurants.dto;


import lombok.Data;


@Data
public class RestaurantDTO {
    private int id;
    private String restaurantName;
    private String address;
    private String city;
    private String restaurantDescription;

}
