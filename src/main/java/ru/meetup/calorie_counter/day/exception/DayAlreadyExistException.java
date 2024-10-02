package ru.meetup.calorie_counter.day.exception;

public class DayAlreadyExistException extends RuntimeException {

    public DayAlreadyExistException(String message) {
        super(message);
    }
}
