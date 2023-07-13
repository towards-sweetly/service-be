package com.management.servicebe.food.application;

import com.management.servicebe.food.dto.FoodDetailRequest;
import com.management.servicebe.food.dto.FoodDetailResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class FoodQueryService {

    private final FoodRepository foodRepository;

    public FoodDetailResponse findFoodDetail(final FoodDetailRequest request) {
        final var food = foodRepository.findById(request.id()).orElseThrow(IllegalArgumentException::new);
        return new FoodDetailResponse(food.getName(), food.getCategory(), food.getServingSizeGram(),
                food.getCaloriesKcal(), food.getCarbohydratesGram(), food.getProteinGram(), food.getFatGram(),
                food.getSugarsGram(), food.getSodiumMilliGram(), food.getCholesterolMilliGram(),
                food.getSaturatedFattyAcidsGram(), food.getTransFattyAcidsGram());
    }
}
