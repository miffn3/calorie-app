package ru.meetup.calorie_counter.day.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.validator.constraints.UUID;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.meetup.calorie_counter.day.service.DayService;
import ru.meetup.calorie_counter.day.web.dto.response.DayDto;

import java.time.LocalDate;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/v1/users/{userId}/days")
public class DayController {

    private final DayService dayService;

    @GetMapping(value = "/")
    public DayDto getDay(@RequestParam("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date,
                         @PathVariable("userId") @Valid @UUID String userId) {
        return dayService.getDay(java.util.UUID.fromString(userId), date);
    }

    @DeleteMapping(value = "/")
    public void deleteDay(@RequestParam("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date,
                          @RequestParam("userId") @Valid @UUID String userId) {
        dayService.deleteDay(java.util.UUID.fromString(userId), date);
    }
}
