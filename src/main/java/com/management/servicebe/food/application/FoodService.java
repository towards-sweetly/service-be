package com.management.servicebe.food.application;

import com.management.servicebe.dto.FoodDto;
import java.util.List;
import org.springframework.data.domain.Pageable;

public interface FoodService {
    List<FoodDto> searchFoods(String searchWord, Pageable pageable);
}
