package com.kirsing.restaurants.service;


import com.kirsing.restaurants.dto.RestaurantDTO;
import com.kirsing.restaurants.entity.Restaurant;
import com.kirsing.restaurants.mapper.RestaurantMapper;
import com.kirsing.restaurants.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class RestaurantService {

    @Autowired
    RestaurantRepository restaurantRepo;


    public List<RestaurantDTO> findAllRestaurants() {
        List<Restaurant> restaurants = restaurantRepo.findAll();
        List<RestaurantDTO> restaurantDTOList = restaurants.stream().map(restaurant -> RestaurantMapper.mapToRestaurantDto(restaurant, new RestaurantDTO())).collect(Collectors.toList());
        return restaurantDTOList;
    }

    public RestaurantDTO addRestaurantInDB(RestaurantDTO restaurantDTO) {
        Restaurant savedRestaurant =  restaurantRepo.save(RestaurantMapper.mapToRestaurant(restaurantDTO, new Restaurant()));
        return RestaurantMapper.mapToRestaurantDto(savedRestaurant, new RestaurantDTO());
    }

    public ResponseEntity<RestaurantDTO> fetchRestaurantById(Integer id) {
        Optional<Restaurant> restaurant =  restaurantRepo.findById(id);
        if(restaurant.isPresent()){
            return new ResponseEntity<>(RestaurantMapper.mapToRestaurantDto(restaurant.get(), new RestaurantDTO()), HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }
}
