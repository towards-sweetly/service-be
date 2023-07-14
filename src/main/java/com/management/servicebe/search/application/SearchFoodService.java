package com.management.servicebe.search.application;

import com.management.servicebe.dto.FoodDto;
import com.management.servicebe.food.application.SearchingFoodService;
import java.util.Collections;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

//todo 해당 클래스의 역할이 단순 위임인게 조금 아쉬운데 나중에 해당 의존을 스킵하던지(SearchController -> FoodService) 유지하던지 한다.

@RequiredArgsConstructor
@Service
public class SearchFoodService {

    private final SearchingFoodService searchingFoodService;

    public List<FoodDto> searchFoods(String searchWord, Pageable pageable) {
        if (searchWord == null || searchWord.isBlank()) {
            return Collections.emptyList();
        }

        return searchingFoodService.searchFoods(searchWord, pageable);
    }
}
