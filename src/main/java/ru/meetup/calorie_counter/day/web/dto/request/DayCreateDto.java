package ru.meetup.calorie_counter.day.web.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;

import java.util.List;
import java.util.UUID;

public record DayCreateDto(
        @Schema(name = "mealIds", example = "[\"7a895e31-9154-4541-81eb-45f678bb4971\", \"7a895e31-9154-4541-81eb-45f678bb4972\"]", description = "Список идентификаторов приемов пищи")
        List<UUID> mealIds
) {
}
