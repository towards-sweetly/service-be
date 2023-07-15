package com.management.servicebe.food.application;

import com.management.servicebe.dto.FoodDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static com.management.servicebe.food.stubs.FoodStub.바나나칩;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.mockito.BDDMockito.given;


@ExtendWith(MockitoExtension.class)
class FoodQueryServiceTest {

    @Mock
    private FoodRepository foodRepository;

    @InjectMocks
    private FoodQueryService foodQueryService;

    @Test
    @DisplayName("식품 상세 정보를 조회한다.")
    void findFoodDetail() {
        // given
        long id = 1L;
        given(foodRepository.findById(id)).willReturn(Optional.of(바나나칩));

        // when
        var 음식_상세_정보 = foodQueryService.findFoodDetail(id);

        // then
        assertAll(
                () -> assertThat(음식_상세_정보.name()).isEqualTo(바나나칩.getName()),
                () -> assertThat(음식_상세_정보.category()).isEqualTo(바나나칩.getCategory()),
                () -> assertThat(음식_상세_정보.servingSizeGram()).isEqualTo(바나나칩.getServingSizeGram()),
                () -> assertThat(음식_상세_정보.caloriesKcal()).isEqualTo(바나나칩.getCaloriesKcal()),
                () -> assertThat(음식_상세_정보.carbohydratesGram()).isEqualTo(바나나칩.getCarbohydratesGram()),
                () -> assertThat(음식_상세_정보.proteinGram()).isEqualTo(바나나칩.getProteinGram()),
                () -> assertThat(음식_상세_정보.fatGram()).isEqualTo(바나나칩.getFatGram()),
                () -> assertThat(음식_상세_정보.sugarsGram()).isEqualTo(바나나칩.getSugarsGram()),
                () -> assertThat(음식_상세_정보.sodiumMilliGram()).isEqualTo(바나나칩.getSodiumMilliGram()),
                () -> assertThat(음식_상세_정보.cholesterolMilliGram()).isEqualTo(바나나칩.getCholesterolMilliGram()),
                () -> assertThat(음식_상세_정보.saturatedFattyAcidsGram()).isEqualTo(바나나칩.getSaturatedFattyAcidsGram()),
                () -> assertThat(음식_상세_정보.transFattyAcidsGram()).isEqualTo(바나나칩.getTransFattyAcidsGram())
        );
    }

    @ParameterizedTest
    @ValueSource(strings = {"바나", "칩", "바나나칩"})
    @DisplayName("식품을_검색한다")
    void searchFoods(String keyword) {
        // given
        given(foodRepository.findByNameContaining(keyword)).willReturn(List.of(바나나칩));

        // when
        var result = foodQueryService.searchFoods(keyword);

        // then
        assertThat(result).contains(new FoodDto(바나나칩.getName()));
    }
}
