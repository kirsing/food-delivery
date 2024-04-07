package com.kirsing.restaurants.mapper;


import com.kirsing.restaurants.dto.RestaurantDTO;
import com.kirsing.restaurants.entity.Restaurant;

public class RestaurantMapper {
    public static RestaurantDTO mapToRestaurantDto(Restaurant restaurant, RestaurantDTO restaurantDTO) {
        restaurantDTO.setId(restaurant.getId());
        restaurantDTO.setRestaurantDescription(restaurant.getRestaurantDescription());
        restaurantDTO.setRestaurantName(restaurant.getRestaurantName());
        restaurantDTO.setCity(restaurant.getCity());
        restaurantDTO.setAddress(restaurant.getAddress());
        return restaurantDTO;
    }

    public static Restaurant mapToRestaurant(RestaurantDTO restaurantDTO, Restaurant restaurant) {
        restaurant.setId(restaurantDTO.getId());
        restaurant.setRestaurantDescription(restaurantDTO.getRestaurantDescription());
        restaurant.setRestaurantName(restaurantDTO.getRestaurantName());
        restaurant.setCity(restaurantDTO.getCity());
        restaurant.setAddress(restaurantDTO.getAddress());
        return restaurant;
    }
}

