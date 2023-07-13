package com.management.servicebe.food.application;

import com.management.servicebe.food.domain.Food;

import java.util.Optional;

public interface FoodRepository {

    Optional<Food> findById(Long id);
}
