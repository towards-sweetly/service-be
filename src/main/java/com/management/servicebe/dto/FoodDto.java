package com.management.servicebe.dto;

import com.management.servicebe.food.domain.Food;

public record FoodDto(
        String name
) {

    public static FoodDto toDto(Food food) {
        return new FoodDto(food.getName());
    }
}
