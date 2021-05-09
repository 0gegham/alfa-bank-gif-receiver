package app.controllers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class ApplicationMainControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void differenceOfOneDay() throws Exception {
        ResultActions resultActions = mockMvc.perform(get("/difference_one_day")
                .param("base", "USD"))
                .andExpect(status().isOk());
        assertThat(resultActions.andReturn().getResponse().getContentAsByteArray()).isNotEmpty();
    }
}