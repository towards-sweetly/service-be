package com.management.servicebe.food.application;

import com.management.servicebe.dto.FoodDto;

import java.util.List;

public interface SearchingFoodService {
    List<FoodDto> searchFoods(String searchWord);
}
