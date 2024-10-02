package ru.meetup.calorie_counter.common.web;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import ru.meetup.calorie_counter.common.web.response.ErrorResponse;
import ru.meetup.calorie_counter.day.exception.DayAlreadyExistException;
import ru.meetup.calorie_counter.day.exception.DayNotFoundException;
import ru.meetup.calorie_counter.meal.exception.MealNotFoundException;
import ru.meetup.calorie_counter.product.exception.ProductNotFoundException;
import ru.meetup.calorie_counter.user.exception.UserAlreadyExistException;
import ru.meetup.calorie_counter.user.exception.UserNotFoundException;

@ControllerAdvice
@Log4j2
@RequiredArgsConstructor
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    @SneakyThrows
    ResponseEntity<Object> handleException(Exception ex, WebRequest request) {
        log.error("Exception occurred: ", ex);
        log.info("request: {}", request);

        return ResponseEntity.status(500).body(new ErrorResponse(ex.getMessage()));
    }

    @ExceptionHandler(UserNotFoundException.class)
    @SneakyThrows
    ResponseEntity<Object> handleUserNotFoundException(UserNotFoundException ex, WebRequest request) {
        log.error("UserNotFoundException occurred: ", ex);
        log.info("request: {}", request);

        return ResponseEntity.status(404).body(new ErrorResponse(ex.getMessage()));
    }

    @ExceptionHandler(UserAlreadyExistException.class)
    @SneakyThrows
    ResponseEntity<Object> handleUserAlreadyExistException(UserAlreadyExistException ex, WebRequest request) {
        log.error("UserAlreadyExistException occurred: ", ex);
        log.info("request: {}", request);

        return ResponseEntity.status(409).body(new ErrorResponse(ex.getMessage()));
    }

    @ExceptionHandler(DayNotFoundException.class)
    @SneakyThrows
    ResponseEntity<Object> handleDayNotFoundException(DayNotFoundException ex, WebRequest request) {
        log.error("DayNotFoundException occurred: ", ex);
        log.info("request: {}", request);

        return ResponseEntity.status(404).body(new ErrorResponse(ex.getMessage()));
    }


    @ExceptionHandler(DayAlreadyExistException.class)
    @SneakyThrows
    ResponseEntity<Object> handleDayAlreadyExistException(DayAlreadyExistException ex, WebRequest request) {
        log.error("DayAlreadyExistException occurred: ", ex);
        log.info("request: {}", request);

        return ResponseEntity.status(409).body(new ErrorResponse(ex.getMessage()));
    }

    @ExceptionHandler(MealNotFoundException.class)
    @SneakyThrows
    ResponseEntity<Object> handleMealNotFoundException(MealNotFoundException ex, WebRequest request) {
        log.error("MealNotFoundException occurred: ", ex);
        log.info("request: {}", request);

        return ResponseEntity.status(404).body(new ErrorResponse(ex.getMessage()));
    }

    @ExceptionHandler(ProductNotFoundException.class)
    @SneakyThrows
    ResponseEntity<Object> handleProductNotFoundException(ProductNotFoundException ex, WebRequest request) {
        log.error("ProductNotFoundException occurred: ", ex);
        log.info("request: {}", request);

        return ResponseEntity.status(404).body(new ErrorResponse(ex.getMessage()));
    }
}
