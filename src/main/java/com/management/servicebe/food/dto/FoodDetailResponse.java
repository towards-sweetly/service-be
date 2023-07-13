package com.management.servicebe.food.dto;

import com.management.servicebe.food.domain.Category;

import java.math.BigDecimal;

public record FoodDetailResponse(
        String name,
        Category category,
        BigDecimal servingSizeGram,
        BigDecimal caloriesKcal,
        BigDecimal carbohydratesGram,
        BigDecimal proteinGram,
        BigDecimal fatGram,
        BigDecimal sugarsGram,
        BigDecimal sodiumMilliGram,
        BigDecimal cholesterolMilliGram,
        BigDecimal saturatedFattyAcidsGram,
        BigDecimal transFattyAcidsGram) {
}
