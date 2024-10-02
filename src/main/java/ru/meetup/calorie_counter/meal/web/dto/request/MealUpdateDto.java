package ru.meetup.calorie_counter.meal.web.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;

import java.util.Set;
import java.util.UUID;

public record MealUpdateDto(
        @Schema(name = "name", example = "Завтрак", description = "Название приема пищи")
        String name,
        @Schema(name = "productIds", example = "[\"7a895e31-9154-4541-81eb-45f678bb4971\", \"7a895e31-9154-4541-81eb-45f678bb4972\"]", description = "Список идентификаторов продуктов")
        Set<UUID> productIds
) {
}