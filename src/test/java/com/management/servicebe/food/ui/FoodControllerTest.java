package com.management.servicebe.food.ui;

import com.management.servicebe.food.application.FoodQueryService;
import com.management.servicebe.food.dto.FoodDetailResponse;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static com.management.servicebe.food.stubs.FoodStub.바나나칩;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@ExtendWith(MockitoExtension.class)
@WebMvcTest(controllers = FoodController.class)
class FoodControllerTest {
    @MockBean
    private FoodQueryService foodQueryService;
    @Autowired
    private MockMvc mockMvc;

    @Test
    void findFoodDetail() throws Exception {
        when(foodQueryService.findFoodDetail(1L)).thenReturn(FoodDetailResponse.of(바나나칩));

        ResultActions actions = mockMvc.perform(
                get("/foods/{id}", 1)
        );

        assertThat(actions.andReturn().getResponse().getStatus())
                .isEqualTo(HttpStatus.OK.value());
    }
}
