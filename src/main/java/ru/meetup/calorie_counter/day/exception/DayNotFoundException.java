package ru.meetup.calorie_counter.day.exception;

public class DayNotFoundException extends RuntimeException {

    public DayNotFoundException(String message) {
        super(message);
    }
}
