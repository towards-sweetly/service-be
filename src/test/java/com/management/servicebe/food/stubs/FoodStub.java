package com.management.servicebe.food.stubs;

import com.management.servicebe.food.domain.Category;
import com.management.servicebe.food.domain.Food;

import java.math.BigDecimal;

public class FoodStub {
    public static final Food 바나나칩 = Food.builder()
            .name("바나나칩")
            .category(Category.FOOD)
            .servingSizeGram(BigDecimal.valueOf(30.0))
            .caloriesKcal(BigDecimal.valueOf(49.5))
            .carbohydratesGram(BigDecimal.valueOf(5.4))
            .proteinGram(BigDecimal.valueOf(0.3))
            .sugarsGram(BigDecimal.valueOf(3.3))
            .sodiumMilliGram(BigDecimal.valueOf(0.6))
            .cholesterolMilliGram(BigDecimal.ZERO)
            .saturatedFattyAcidsGram(BigDecimal.valueOf(2.7))
            .transFattyAcidsGram(BigDecimal.ZERO)
            .build();
}
