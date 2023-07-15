package com.management.servicebe.food.ui.response;

import com.management.servicebe.food.domain.Category;
import com.management.servicebe.food.domain.Food;

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

    public static FoodDetailResponse of(Food food) {
        return new FoodDetailResponse(food.getName(), food.getCategory(), food.getServingSizeGram(),
                food.getCaloriesKcal(), food.getCarbohydratesGram(), food.getProteinGram(), food.getFatGram(),
                food.getSugarsGram(), food.getSodiumMilliGram(), food.getCholesterolMilliGram(),
                food.getSaturatedFattyAcidsGram(), food.getTransFattyAcidsGram());
    }
}
