package ru.meetup.calorie_counter.day.web.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Set;
import java.util.UUID;

public record DayDto(
        @Schema(name = "id", example = "7a895e31-9154-4541-81eb-45f678bb4971", description = "Идентификатор дня")
        UUID id,
        @Schema(name = "date", example = "2025-10-01", description = "Дата")
        LocalDate date,
        @Schema(name = "calories", example = "120.2", description = "Калории")
        BigDecimal calories,
        @Schema(name = "proteins", example = "7.2", description = "Белки")
        BigDecimal proteins,
        @Schema(name = "fats", example = "7.2", description = "Жиры")
        BigDecimal fats,
        @Schema(name = "carbohydrates", example = "23.1", description = "Углеводы")
        BigDecimal carbohydrates,
        @Schema(name = "mealIds", example = "[\"7a895e31-9154-4541-81eb-45f678bb4971\", \"7a895e31-9154-4541-81eb-45f678bb4972\"]", description = "Список идентификаторов приемов пищи")
        Set<UUID> mealIds
) {
}
