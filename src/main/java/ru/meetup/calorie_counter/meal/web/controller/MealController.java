package ru.meetup.calorie_counter.meal.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.validator.constraints.UUID;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.meetup.calorie_counter.meal.service.MealService;
import ru.meetup.calorie_counter.meal.web.dto.request.MealCreateDto;
import ru.meetup.calorie_counter.meal.web.dto.request.MealUpdateDto;
import ru.meetup.calorie_counter.meal.web.dto.response.MealDto;

import java.time.LocalDate;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/users/{userId}/days/{day}/meals")
public class MealController {

    private final MealService mealService;

    @PostMapping("/")
    public MealDto createMeal(@PathVariable @Valid @UUID String userId,
                              @PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate day,
                              @RequestBody MealCreateDto mealCreateDto) {
        return mealService.createMeal(java.util.UUID.fromString(userId), day, mealCreateDto);
    }

    @GetMapping("/{mealId}")
    public MealDto getMeal(@PathVariable @Valid @UUID String mealId) {
        return mealService.getMeal(java.util.UUID.fromString(mealId));
    }

    @PatchMapping("/{mealId}")
    public MealDto updateMeal(@PathVariable @Valid @UUID String mealId, @RequestBody MealUpdateDto mealUpdateDto) {
        return mealService.updateMeal(java.util.UUID.fromString(mealId), mealUpdateDto);
    }

    @DeleteMapping("/{mealId}")
    public void deleteMeal(@PathVariable @Valid @UUID String mealId) {
        mealService.deleteMeal(java.util.UUID.fromString(mealId));
    }
}
