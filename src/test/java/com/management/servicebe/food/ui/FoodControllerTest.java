package com.management.servicebe.food.ui;

import com.management.servicebe.food.application.FoodQueryService;
import com.management.servicebe.food.ui.response.FoodDetailResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.test.web.servlet.MockMvc;

import static com.management.servicebe.food.stubs.FoodStub.바나나칩;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@WebMvcTest(controllers = FoodController.class)
class FoodControllerTest {
    @MockBean
    private FoodQueryService foodQueryService;
    @Autowired
    private MockMvc mockMvc;

    @Test
    void findFoodDetail() throws Exception {
        given(foodQueryService.findFoodDetail(1L)).willReturn(FoodDetailResponse.of(바나나칩));

        var actions = mockMvc.perform(
                get("/foods/{id}", 1)
        );

        assertThat(actions.andReturn().getResponse().getStatus()).isEqualTo(HttpStatus.OK.value());
    }
}
