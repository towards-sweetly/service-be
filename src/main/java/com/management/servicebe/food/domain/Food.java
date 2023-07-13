package com.management.servicebe.food.domain;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.math.BigDecimal;

@Getter
@ToString(onlyExplicitlyIncluded = true)
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Food {

    @EqualsAndHashCode.Include
    @ToString.Include
    private Long id;
    @ToString.Include
    private final String name;
    @ToString.Include
    private final Category category;
    private final BigDecimal servingSizeGram;
    private final BigDecimal caloriesKcal;
    private final BigDecimal carbohydratesGram;
    private final BigDecimal proteinGram;
    private final BigDecimal fatGram;
    private final BigDecimal sugarsGram;
    private final BigDecimal sodiumMilliGram;
    private final BigDecimal cholesterolMilliGram;
    private final BigDecimal saturatedFattyAcidsGram;
    private final BigDecimal transFattyAcidsGram;

    public Food(Long id, String name, Category category, BigDecimal servingSizeGram, BigDecimal caloriesKcal,
                BigDecimal carbohydratesGram, BigDecimal proteinGram, BigDecimal fatGram, BigDecimal sugarsGram,
                BigDecimal sodiumMilliGram, BigDecimal cholesterolMilliGram, BigDecimal saturatedFattyAcidsGram,
                BigDecimal transFattyAcidsGram) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.servingSizeGram = servingSizeGram;
        this.caloriesKcal = caloriesKcal;
        this.carbohydratesGram = carbohydratesGram;
        this.proteinGram = proteinGram;
        this.fatGram = fatGram;
        this.sugarsGram = sugarsGram;
        this.sodiumMilliGram = sodiumMilliGram;
        this.cholesterolMilliGram = cholesterolMilliGram;
        this.saturatedFattyAcidsGram = saturatedFattyAcidsGram;
        this.transFattyAcidsGram = transFattyAcidsGram;
    }

    @Builder
    public Food(String name, Category category, BigDecimal servingSizeGram, BigDecimal caloriesKcal,
                BigDecimal carbohydratesGram, BigDecimal proteinGram, BigDecimal fatGram, BigDecimal sugarsGram,
                BigDecimal sodiumMilliGram, BigDecimal cholesterolMilliGram, BigDecimal saturatedFattyAcidsGram,
                BigDecimal transFattyAcidsGram) {
        this(null, name, category, servingSizeGram, caloriesKcal, carbohydratesGram, proteinGram, fatGram,
                sugarsGram, sodiumMilliGram, cholesterolMilliGram, saturatedFattyAcidsGram, transFattyAcidsGram);
    }
}
