package com.management.servicebe.food.infra;

import com.management.servicebe.dto.FoodDto;
import com.management.servicebe.food.application.FoodRepository;
import com.management.servicebe.food.domain.Food;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class InMemoryFoodRepository implements FoodRepository {

    private final Map<Long, Food> storage = new HashMap<>();
    private Long sequence = 0L;

    @Override
    public Optional<Food> findById(Long id) {
        return Optional.of(storage.get(id));
    }

    @Override
    public List<Food> findByNameContaining(String searchWord) {
        return storage.values().stream().filter(food -> food.getName()
                .contains(searchWord)).collect(Collectors.toList());
    }

    public Food save(Food food) {
        var newFood = new Food(++sequence, food.getName(), food.getCategory(), food.getServingSizeGram(),
                food.getCaloriesKcal(), food.getCarbohydratesGram(), food.getProteinGram(), food.getFatGram(),
                food.getSugarsGram(), food.getSodiumMilliGram(), food.getCholesterolMilliGram(),
                food.getSaturatedFattyAcidsGram(), food.getTransFattyAcidsGram());

        storage.put(newFood.getId(), newFood);

        return newFood;
    }
}
