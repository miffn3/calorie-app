package ru.meetup.calorie_counter.user.web.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record UserCreateDto(
        @NotNull
        @Schema(name = "weight", example = "70.1", description = "Вес", requiredMode = Schema.RequiredMode.REQUIRED)
        BigDecimal weight,
        @NotNull
        @Schema(name = "height", example = "170.1", description = "Рост", requiredMode = Schema.RequiredMode.REQUIRED)
        BigDecimal height,
        @NotNull
        @Schema(name = "age", example = "26", description = "Возраст", requiredMode = Schema.RequiredMode.REQUIRED)
        int age
) {
}
