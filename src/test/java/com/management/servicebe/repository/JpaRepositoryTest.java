package com.management.servicebe.repository;

import static org.assertj.core.api.Assertions.assertThat;

import com.management.servicebe.food.domain.Food;
import com.management.servicebe.food.infra.FoodRepository;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
class JpaRepositoryTest {

    @Autowired
    private FoodRepository foodRepository;

    @AfterEach
    void after() {
        foodRepository.deleteAll();
    }

    @DisplayName("select 테스트")
    @Test
    void test1() {
        // given
        Food food = new Food("라면");
        Food food2 = new Food("콜라");
        Food food3 = new Food("파스타");
        Food food4 = new Food("이름모를");
        foodRepository.save(food);
        foodRepository.save(food2);
        foodRepository.save(food3);
        foodRepository.save(food4);

        // when
        List<Food> foods = foodRepository.findAll();

        // then
        assertThat(foods)
                .isNotNull()
                .hasSize(4);
    }

    @DisplayName("검색 테스트")
    @Test
    void test2() {
        //given
        Food food = new Food("라면");
        Food food2 = new Food("콜라");
        Food food3 = new Food("파스타");
        Food food4 = new Food("이름모를");
        foodRepository.save(food);
        foodRepository.save(food2);
        foodRepository.save(food3);
        foodRepository.save(food4);

        Pageable pageable = PageRequest.of(0, 4, Sort.by(
                Sort.Order.asc("name")
        ));

        //when
        List<Food> foods = foodRepository.findByNameContaining("콜", pageable);

        //then
        assertThat(foods)
                .isNotNull()
                .hasSize(1);
    }
}
