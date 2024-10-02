package ru.meetup.calorie_counter.meal.service;

import ru.meetup.calorie_counter.meal.web.dto.request.MealCreateDto;
import ru.meetup.calorie_counter.meal.web.dto.request.MealUpdateDto;
import ru.meetup.calorie_counter.meal.web.dto.response.MealDto;

import java.time.LocalDate;
import java.util.UUID;

public interface MealService {
    MealDto createMeal(UUID userId, LocalDate date, MealCreateDto mealCreateDto);

    void deleteMeal(UUID mealId);

    MealDto updateMeal(UUID mealId, MealUpdateDto mealUpdateDto);

    MealDto getMeal(UUID mealId);
}
