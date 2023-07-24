package com.management.servicebe.search.ui;

import com.management.servicebe.search.application.SearchFoodService;
import com.management.servicebe.search.ui.response.SearchResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class SearchRestController {

    private final SearchFoodService searchFoodService;

    @GetMapping("/foods")
    public SearchResponseDto searchFood(
            @RequestParam String searchWord
    ) {

        return new SearchResponseDto(searchFoodService.searchFoods(searchWord));
    }
}
