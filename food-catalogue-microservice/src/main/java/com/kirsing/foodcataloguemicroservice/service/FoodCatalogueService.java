package com.kirsing.foodcataloguemicroservice.service;

import com.kirsing.foodcataloguemicroservice.dto.FoodCataloguePage;
import com.kirsing.foodcataloguemicroservice.dto.FoodItemDTO;
import com.kirsing.foodcataloguemicroservice.dto.Restaurant;
import com.kirsing.foodcataloguemicroservice.entity.FoodItem;
import com.kirsing.foodcataloguemicroservice.mapper.FoodItemMapper;
import com.kirsing.foodcataloguemicroservice.repository.FoodItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class FoodCatalogueService {

    @Autowired
    FoodItemRepository foodItemRepository;

    @Autowired
    RestTemplate restTemplate;


    public FoodItemDTO addFoodItem(FoodItemDTO foodItemDTO) {
        FoodItem foodItemSavedInDB = foodItemRepository.save(FoodItemMapper.mapToFoodItem(foodItemDTO, new FoodItem()));
        return FoodItemMapper.mapToFoodItemDto(foodItemSavedInDB, new FoodItemDTO());
    }

    public FoodCataloguePage fetchFoodCataloguePageDetails(Integer restaurantId) {
        List<FoodItem> foodItemList =  fetchFoodItemList(restaurantId);
        Restaurant restaurant = fetchRestaurantDetailsFromRestaurantMS(restaurantId);
        return createFoodCataloguePage(foodItemList, restaurant);
    }

    private FoodCataloguePage createFoodCataloguePage(List<FoodItem> foodItemList, Restaurant restaurant) {
        FoodCataloguePage foodCataloguePage = new FoodCataloguePage();
        foodCataloguePage.setFoodItemsList(foodItemList);
        foodCataloguePage.setRestaurant(restaurant);
        return foodCataloguePage;
    }

    private Restaurant fetchRestaurantDetailsFromRestaurantMS(Integer restaurantId) {
        return restTemplate.getForObject("http://RESTAURANT-SERVICE/restaurant/fetchById/"+restaurantId, Restaurant.class);
    }

    private List<FoodItem> fetchFoodItemList(Integer restaurantId) {
        return foodItemRepository.findByRestaurantId(restaurantId);
    }
}


