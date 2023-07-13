package com.management.servicebe.food.application;

import com.management.servicebe.food.dto.FoodDetailResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class FoodQueryService {

    private final FoodRepository foodRepository;

    public FoodDetailResponse findFoodDetail(final Long id) {
        final var food = foodRepository.findById(id).orElseThrow(IllegalArgumentException::new);
        return FoodDetailResponse.of(food);
    }
}
