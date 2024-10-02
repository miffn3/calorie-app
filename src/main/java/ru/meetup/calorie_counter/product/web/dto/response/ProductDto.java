package ru.meetup.calorie_counter.product.web.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;

import java.math.BigDecimal;
import java.util.UUID;

public record ProductDto(
        @Schema(name = "id", example = "7a895e31-9154-4541-81eb-45f678bb4971", description = "Идентификатор продукта")
        UUID id,
        @Schema(name = "name", example = "Яблоко", description = "Название продукта")
        String name,
        @Schema(name = "calories", example = "52", description = "Калорийность")
        BigDecimal calories,
        @Schema(name = "proteins", example = "0.3", description = "Белки")
        BigDecimal proteins,
        @Schema(name = "fats", example = "0.2", description = "Жиры")
        BigDecimal fats,
        @Schema(name = "carbohydrates", example = "13", description = "Углеводы")
        BigDecimal carbohydrates
) {
}