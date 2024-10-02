package ru.meetup.calorie_counter.product.web.dto.request;

import java.math.BigDecimal;

public record ProductUpdateDto(
        String name,
        BigDecimal calories,
        BigDecimal proteins,
        BigDecimal fats,
        BigDecimal carbohydrates
) {
}
