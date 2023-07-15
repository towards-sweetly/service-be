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
                    .servingSizeGram(BigDecimal.valueOf(30.0))
                    .caloriesKcal(BigDecimal.valueOf(49.5))
                    .carbohydratesGram(BigDecimal.valueOf(5.4))
                    .proteinGram(BigDecimal.valueOf(0.3))
                    .sugarsGram(BigDecimal.valueOf(3.3))
                    .sodiumMilliGram(BigDecimal.valueOf(0.6))
                    .cholesterolMilliGram(BigDecimal.ZERO)
                    .saturatedFattyAcidsGram(BigDecimal.valueOf(2.7))
                    .transFattyAcidsGram(BigDecimal.ZERO)
                    .build());
        };
    }
}
