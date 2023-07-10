package com.management.servicebe.food.application;

import com.management.servicebe.dto.FoodDto;
import com.management.servicebe.food.infra.FoodRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class FoodServiceImpl implements FoodService {

    private final FoodRepository foodRepository;

    @Transactional(readOnly = true)
    @Override
    public List<FoodDto> searchFoods(String searchWord, Pageable pageable) {
        //todo 카테고리를 선택후 검색하거나, 카테고리에 해당되는 결과가 검색될수있다
        return foodRepository.findByNameContaining(searchWord, pageable).stream()
                .map(FoodDto::toDto)
                .toList();
    }
}
