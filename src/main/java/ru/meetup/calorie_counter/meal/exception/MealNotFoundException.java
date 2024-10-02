package ru.meetup.calorie_counter.meal.exception;

public class MealNotFoundException extends RuntimeException {

    public MealNotFoundException(String message) {
        super(message);
    }
}
