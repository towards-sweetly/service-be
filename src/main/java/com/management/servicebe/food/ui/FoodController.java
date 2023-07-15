package com.management.servicebe.food.ui;

import com.management.servicebe.food.application.FoodQueryService;
import com.management.servicebe.food.dto.FoodDetailResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/foods")
public class FoodController {
    private final FoodQueryService foodQueryService;

    @GetMapping("/{id}")
    public FoodDetailResponse findFoodDetail(@PathVariable Long id) {
        return foodQueryService.findFoodDetail(id);
    }

    @GetMapping
    public String hello() {
        return "hello";
    }
}
