package com.management.servicebe.search.application;

import com.management.servicebe.dto.FoodDto;
import com.management.servicebe.food.application.SearchingFoodService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@RequiredArgsConstructor
@Service
public class SearchFoodService {

    private final SearchingFoodService searchingFoodService;

    public List<FoodDto> searchFoods(String searchWord) {
        if (searchWord == null || searchWord.isBlank()) {
            return Collections.emptyList();
        }

        return searchingFoodService.searchFoods(searchWord);
    }
}
