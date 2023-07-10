package com.management.servicebe.food.application;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;

import com.management.servicebe.dto.FoodDto;
import com.management.servicebe.food.domain.Food;
import com.management.servicebe.food.infra.FoodRepository;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

@ExtendWith(MockitoExtension.class)
class SearchingFoodServiceImplTest {

    @InjectMocks
    private SearchingFoodServiceImpl sut;

    @Mock
    private FoodRepository foodRepository;

    @DisplayName("검색어를 입력하지않으면 빈 리스트를 반환한다")
    @ParameterizedTest(name = "[{index}] \"{0}\"")
    @NullSource
    @ValueSource(strings = {""," "})
    void 검색어를_입력하지않으면_빈_리스트를_반환한다(String expected) {
        // given
        Pageable pageable = getPageable(0,4,Sort.unsorted());

        // when
        List<FoodDto> actual = sut.searchFoods(expected, pageable);

        // then
        assertThat(actual).isEmpty();
        then(foodRepository).shouldHaveNoInteractions();
    }
    
    @DisplayName("검색어를 입력하면 해당 검색어가 포함된 음식 리스트를 반환한다")
    @MethodSource
    @ParameterizedTest(name = "[{index}] \"{0}\" => {2}")
    void 검색어를_입력하면_해당_검색어가_포함된_음식_리스트를_반환한다(String input, List<Food> foods, List<FoodDto> expected) {
        // given
        given(foodRepository.findByNameContaining(eq(input), any(Pageable.class))).willReturn(foods);
        Pageable pageable = getPageable(0,4,Sort.unsorted());

        // when
        List<FoodDto> actual = sut.searchFoods(input, pageable);

        // then
        assertThat(actual).containsExactlyInAnyOrderElementsOf(expected);
    }

    static Stream<Arguments> 검색어를_입력하면_해당_검색어가_포함된_음식_리스트를_반환한다() {
        return Stream.of(
                arguments("라면", List.of(makeFood("라면")), List.of(makeFoodDto("라면"))),
                arguments("파스타", List.of(makeFood("파스타")), List.of(makeFoodDto("파스타"))),
                arguments("라", List.of(makeFood("라면"), makeFood("라볶이")),
                        List.of(makeFoodDto("라면"), makeFoodDto("라볶이")))
        );
    }

    private PageRequest getPageable(int page, int size, Sort sort) {
        return PageRequest.of(page, size, sort);
    }

    private static FoodDto makeFoodDto(String name) {
        return new FoodDto(name);
    }

    private static Food makeFood(String name) {
        return new Food(name);
    }
}