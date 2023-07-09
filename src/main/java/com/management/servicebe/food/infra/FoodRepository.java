package com.management.servicebe.food.infra;

import com.management.servicebe.food.domain.Food;
import java.util.List;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodRepository extends JpaRepository<Food, Long> {

    List<Food> findByNameContaining(String searchWord, Pageable pageable);
}
