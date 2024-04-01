package com.kirsing.foodcataloguemicroservice.mapper;

import com.kirsing.foodcataloguemicroservice.dto.FoodItemDTO;
import com.kirsing.foodcataloguemicroservice.entity.FoodItem;

public class FoodItemMapper {
    public static FoodItemDTO mapToFoodItemDto(FoodItem foodItem, FoodItemDTO foodItemDTO) {
        foodItemDTO.setItemName(foodItem.getItemName());
        foodItemDTO.setItemDescription(foodItem.getItemDescription());
        foodItemDTO.setVeg(foodItem.isVeg());
        foodItemDTO.setPrice(foodItem.getPrice());
        foodItemDTO.setQuantity(foodItem.getQuantity());
        foodItemDTO.setRestaurantId(foodItem.getRestaurantId());
        return foodItemDTO;
    }

    public static FoodItem mapToFoodItem(FoodItemDTO foodItemDTO, FoodItem foodItem) {
        foodItem.setItemName(foodItemDTO.getItemName());
        foodItem.setItemDescription(foodItemDTO.getItemDescription());
        foodItem.setVeg(foodItemDTO.isVeg());
        foodItem.setPrice(foodItemDTO.getPrice());
        foodItem.setQuantity(foodItemDTO.getQuantity());
        foodItem.setRestaurantId(foodItemDTO.getRestaurantId());
        return foodItem;
    }
}

