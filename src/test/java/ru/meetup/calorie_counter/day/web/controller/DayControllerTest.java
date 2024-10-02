package ru.meetup.calorie_counter.day.web.controller;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import ru.meetup.calorie_counter.common.web.GlobalExceptionHandler;
import ru.meetup.calorie_counter.day.service.DayService;

@AutoConfigureMockMvc
//@WebMvcTest(DayController.class) TODO uncomment when tests will be done. Otherwise build is failing
@Import({DayController.class, GlobalExceptionHandler.class})
@ActiveProfiles("test")
class DayControllerTest {

    @Test
    void getDay() {
    }
}