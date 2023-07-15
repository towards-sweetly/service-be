package com.management.servicebe.food.infra;

import com.management.servicebe.food.domain.Food;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static com.management.servicebe.food.stubs.FoodStub.바나나칩;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class InMemoryFoodRepositoryTest {

    private InMemoryFoodRepository repository = new InMemoryFoodRepository();
    private Food 저장된_바나나칩;

    @BeforeEach
    void setUp() {
        저장된_바나나칩 = repository.save(바나나칩);
    }

    @ParameterizedTest
    @ValueSource(strings = {"바나", "나칩", "칩", "바나나칩"})
    @DisplayName("검색된 문자열을 포함하는 식품 리스트를 반환한다.")
    void findByNameContainingTest(String keyword) {
        // given & when
        var result = repository.findByNameContaining(keyword);

        // then
        assertAll(
                () -> assertThat(result).hasSize(1),
                () -> assertThat(result).contains(저장된_바나나칩)
        );
    }
}
