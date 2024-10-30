package ru.meetup.calorie_counter.day.web.controller;

import lombok.SneakyThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import ru.meetup.calorie_counter.common.web.GlobalExceptionHandler;
import ru.meetup.calorie_counter.day.service.DayService;
import ru.meetup.calorie_counter.day.web.dto.response.DayDto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Set;
import java.util.UUID;

import static org.hamcrest.Matchers.notNullValue;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@WebMvcTest(controllers = DayController.class)
@ContextConfiguration(classes = {DayController.class, GlobalExceptionHandler.class})
@ActiveProfiles("test")
class DayControllerTest {

    MockMvc mvc;
    @Autowired
    WebApplicationContext context;
    @MockBean
    DayService dayService;

    @BeforeEach
    void beforeEach() {
        mvc = MockMvcBuilders
                .webAppContextSetup(context)
                .addFilters()
                .build();
    }

    @Test
    @SneakyThrows
    void getDay() {
        //given:
        String userUuidString = "952c6961-5558-4f55-ae87-2e5ef9e9a870";
        String dayUuidString = "952c6961-5558-4f55-ae87-2e5ef9e9a871";
        UUID userUuid = UUID.fromString(userUuidString);
        UUID dayUuid = UUID.fromString(dayUuidString);
        LocalDate date = LocalDate.of(2024, 10, 30);
        DayDto dayDto = new DayDto(dayUuid, date, BigDecimal.valueOf(100), BigDecimal.valueOf(12), BigDecimal.valueOf(1), BigDecimal.valueOf(7), Set.of());
        when(dayService.getDay(userUuid, date)).thenReturn(dayDto);
        String response = """
                {
                  "id":"952c6961-5558-4f55-ae87-2e5ef9e9a871",
                  "date":"2024-10-30","calories":100,
                  "proteins":12,
                  "fats":1,
                  "carbohydrates":7,
                  "mealIds":[]
                }
                """;

        //when:
        final ResultActions resultActions = mvc.perform(
                get("/api/v1/users/" + userUuidString + "/days/")
                        .queryParam("date", "2024-10-30")
                        .accept(MediaType.APPLICATION_JSON)
        );

        //then:
        resultActions.andExpect(status().isOk())
                .andExpect(content().string(notNullValue()))
                .andDo(print())
                .andExpect(content().json(response));
    }
}