package ru.meetup.calorie_counter.user.web.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;

import java.math.BigDecimal;
import java.util.UUID;

public record UserDto(
        @Schema(name = "id", example = "7a895e31-9154-4541-81eb-45f678bb4971", description = "Идентификатор пользователя")
        UUID id,
        @Schema(name = "weight", example = "70.1", description = "Вес")
        BigDecimal weight,
        @Schema(name = "height", example = "170.1", description = "Рост")
        BigDecimal height,
        @Schema(name="age", example = "26", description = "Возраст")
        int age
) {
}
