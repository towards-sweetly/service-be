package com.management.servicebe;

import com.management.servicebe.food.domain.Category;
import com.management.servicebe.food.domain.Food;
import com.management.servicebe.food.infra.InMemoryFoodRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.math.BigDecimal;

@Configuration
@RequiredArgsConstructor
public class StorageBootstrap {
    private final InMemoryFoodRepository foodRepository;

    @Bean
    ApplicationRunner init() {
        return args -> {
            foodRepository.save(Food.builder()
                    .name("바나나칩")
                    .category(Category.FOOD)
                    .servingSizeGram(BigDecimal.valueOf(30))
                    .caloriesKcal(BigDecimal.valueOf(49.5))
                    .carbohydratesGram(BigDecimal.valueOf(5.4))
                    .proteinGram(BigDecimal.valueOf(0.3))
                    .fatGram(BigDecimal.valueOf(4))
                    .sugarsGram(BigDecimal.valueOf(3.3))
                    .sodiumMilliGram(BigDecimal.valueOf(0.6))
                    .cholesterolMilliGram(BigDecimal.ZERO)
                    .saturatedFattyAcidsGram(BigDecimal.valueOf(2.7))
                    .transFattyAcidsGram(BigDecimal.ZERO)
                    .build());

            foodRepository.save(Food.builder()
                    .name("메밀, 생것")
                    .category(Category.FOOD)
                    .servingSizeGram(BigDecimal.valueOf(100))
                    .caloriesKcal(BigDecimal.valueOf(374))
                    .carbohydratesGram(BigDecimal.valueOf(74.7))
                    .proteinGram(BigDecimal.valueOf(11.5))
                    .fatGram(BigDecimal.valueOf(2.3))
                    .sugarsGram(null)
                    .sodiumMilliGram(BigDecimal.valueOf(14))
                    .cholesterolMilliGram(BigDecimal.ZERO)
                    .saturatedFattyAcidsGram(BigDecimal.valueOf(0.59))
                    .transFattyAcidsGram(null)
                    .build());

            foodRepository.save(Food.builder()
                    .name("메밀국수, 생면")
                    .category(Category.FOOD)
                    .servingSizeGram(BigDecimal.valueOf(100))
                    .caloriesKcal(BigDecimal.valueOf(274))
                    .carbohydratesGram(BigDecimal.valueOf(61.14))
                    .proteinGram(BigDecimal.valueOf(7.59))
                    .fatGram(BigDecimal.valueOf(0.96))
                    .sugarsGram(BigDecimal.ZERO)
                    .sodiumMilliGram(BigDecimal.valueOf(455))
                    .cholesterolMilliGram(BigDecimal.ZERO)
                    .saturatedFattyAcidsGram(BigDecimal.valueOf(0.27))
                    .transFattyAcidsGram(null)
                    .build());

            foodRepository.save(Food.builder()
                    .name("햄버거")
                    .category(Category.FOOD)
                    .servingSizeGram(BigDecimal.valueOf(100))
                    .caloriesKcal(BigDecimal.valueOf(271))
                    .carbohydratesGram(BigDecimal.valueOf(35.76))
                    .proteinGram(BigDecimal.valueOf(11.94))
                    .fatGram(BigDecimal.valueOf(8.94))
                    .sugarsGram(BigDecimal.valueOf(6.59))
                    .sodiumMilliGram(BigDecimal.valueOf(594))
                    .cholesterolMilliGram(BigDecimal.valueOf(14.77))
                    .saturatedFattyAcidsGram(BigDecimal.valueOf(4.21))
                    .transFattyAcidsGram(BigDecimal.ZERO)
                    .build());

            foodRepository.save(Food.builder()
                    .name("볶은보리")
                    .category(Category.FOOD)
                    .servingSizeGram(BigDecimal.valueOf(100))
                    .caloriesKcal(BigDecimal.valueOf(360))
                    .carbohydratesGram(BigDecimal.valueOf(74.1))
                    .proteinGram(BigDecimal.valueOf(12.7))
                    .fatGram(BigDecimal.valueOf(2.6))
                    .sugarsGram(null)
                    .sodiumMilliGram(BigDecimal.ZERO)
                    .cholesterolMilliGram(null)
                    .saturatedFattyAcidsGram(null)
                    .transFattyAcidsGram(null)
                    .build());
        };
    }
}
