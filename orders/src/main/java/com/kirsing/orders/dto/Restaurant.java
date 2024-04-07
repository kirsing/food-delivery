package com.kirsing.orders.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Restaurant {
    private int id;
    private String restaurantName;
    private String address;
    private String city;
    private String restaurantDescription;

}
