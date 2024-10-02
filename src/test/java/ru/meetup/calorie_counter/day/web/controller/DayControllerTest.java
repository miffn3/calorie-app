package ru.meetup.calorie_counter.day.web.controller;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ActiveProfiles;
import ru.meetup.calorie_counter.common.web.GlobalExceptionHandler;

@AutoConfigureMockMvc
@WebMvcTest(DayController.class)
@Import({DayController.class, GlobalExceptionHandler.class})
@ActiveProfiles("test")
class DayControllerTest {

    @Test
    void getDay() {
    }
}