package com.management.servicebe.food.application;

import com.management.servicebe.dto.FoodDto;
import com.management.servicebe.food.ui.response.FoodDetailResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class FoodQueryService implements SearchingFoodService {

    private final FoodRepository foodRepository;

    public FoodDetailResponse findFoodDetail(final Long id) {
        final var food = foodRepository.findById(id).orElseThrow(IllegalArgumentException::new);
        return FoodDetailResponse.of(food);
    }

    @Override
    public List<FoodDto> searchFoods(String searchWord) {
        return foodRepository.findByNameContaining(searchWord)
                .stream().map(food -> new FoodDto(food.getName()))
                .collect(Collectors.toList());
    }
}
