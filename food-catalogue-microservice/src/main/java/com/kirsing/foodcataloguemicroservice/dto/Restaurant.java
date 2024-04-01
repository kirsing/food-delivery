package com.kirsing.foodcataloguemicroservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Restaurant {
    private int id;
    private String restaurantName;
    private String address;
    private String city;
    private String restaurantDescription;
}