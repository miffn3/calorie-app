package ru.meetup.calorie_counter.user.web.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;

import java.math.BigDecimal;

public record UserUpdateDto(
        @Schema(name = "weight", example = "70.1", description = "Вес")
        BigDecimal weight,
        @Schema(name = "height", example = "170.1", description = "Рост")
        BigDecimal height,
        @Schema(name="age", example = "26", description = "Возраст")
        int age
) {
}
