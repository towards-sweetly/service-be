package com.management.servicebe.search.ui.response;

import com.management.servicebe.dto.FoodDto;
import java.util.List;

public record SearchResponseDto(
        List<FoodDto> searchResponses
) {

}
