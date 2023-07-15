package com.management.servicebe.food.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class FoodTest {

    @Test
    @DisplayName("""
            식품은 식품 이름, 카테고리, 1회 제공량(g), 열량(kcal), 탄수화물(g), 단백질(g), 지방(g), 당류(g), 나트륨(mg), 콜레스테롤(mg), 포화지방산(g), 트랜스지방산(g)으로 구성된다.
            """)
    void createFood() {
        // given
        var name = "바나나칩";
        var cholesterol = BigDecimal.ZERO;
        var servingSize = BigDecimal.valueOf(30.0);
        var calories = BigDecimal.valueOf(49.5);
        var carbohydrates = BigDecimal.valueOf(5.4);
        var protein = BigDecimal.valueOf(0.3);
        var fat = BigDecimal.valueOf(4);
        var sugar = BigDecimal.valueOf(3.3);
        var sodium = BigDecimal.valueOf(0.6);
        var saturatedFattyAcidsG = BigDecimal.valueOf(2.7);
        var transFattyAcids = BigDecimal.ZERO;
        var category = Category.FOOD;

        // when
        var 바나나칩 = Food.builder()
                .name(name)
                .category(category)
                .servingSizeGram(servingSize)
                .caloriesKcal(calories)
                .carbohydratesGram(carbohydrates)
                .proteinGram(protein)
                .fatGram(fat)
                .sugarsGram(sugar)
                .sodiumMilliGram(sodium)
                .cholesterolMilliGram(cholesterol)
                .saturatedFattyAcidsGram(saturatedFattyAcidsG)
                .transFattyAcidsGram(transFattyAcids)
                .build();

        // then
        assertAll(
                () -> assertThat(바나나칩.getName()).isEqualTo(name),
                () -> assertThat(바나나칩.getCategory()).isEqualTo(category),
                () -> assertThat(바나나칩.getServingSizeGram()).isEqualTo(servingSize),
                () -> assertThat(바나나칩.getCaloriesKcal()).isEqualTo(calories),
                () -> assertThat(바나나칩.getCarbohydratesGram()).isEqualTo(carbohydrates),
                () -> assertThat(바나나칩.getProteinGram()).isEqualTo(protein),
                () -> assertThat(바나나칩.getFatGram()).isEqualTo(fat),
                () -> assertThat(바나나칩.getSugarsGram()).isEqualTo(sugar),
                () -> assertThat(바나나칩.getSodiumMilliGram()).isEqualTo(sodium),
                () -> assertThat(바나나칩.getCholesterolMilliGram()).isEqualTo(cholesterol),
                () -> assertThat(바나나칩.getSaturatedFattyAcidsGram()).isEqualTo(saturatedFattyAcidsG),
                () -> assertThat(바나나칩.getTransFattyAcidsGram()).isEqualTo(transFattyAcids)
        );
    }
}
