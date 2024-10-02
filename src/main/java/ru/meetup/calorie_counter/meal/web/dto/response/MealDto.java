package ru.meetup.calorie_counter.meal.web.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;

import java.math.BigDecimal;
import java.util.Set;
import java.util.UUID;

public record MealDto(
        @Schema(name = "id", example = "7a895e31-9154-4541-81eb-45f678bb4971", description = "Идентификатор приема пищи")
        UUID id,
        @Schema(name = "name", example = "Завтрак", description = "Название приема пищи")
        String name,
        @Schema(name = "calories", example = "130.1", description = "Калории")
        BigDecimal calories,
        @Schema(name = "proteins", example = "12.5", description = "Белки")
        BigDecimal proteins,
        @Schema(name = "fats", example = "10.1", description = "Жиры")
        BigDecimal fats,
        @Schema(name = "carbohydrates", example = "10.1", description = "Углеводы")
        BigDecimal carbohydrates,
        @Schema(name = "productIds", example = "[\"7a895e31-9154-4541-81eb-45f678bb4971\", \"7a895e31-9154-4541-81eb-45f678bb4972\"]", description = "Список идентификаторов продуктов")
        Set<UUID> productIds
) {
}
