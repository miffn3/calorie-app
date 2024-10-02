package ru.meetup.calorie_counter.product.web.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record ProductCreateDto(
        @NotBlank
        @Schema(name = "name", example = "Хлеб", description = "Название продукта", requiredMode = Schema.RequiredMode.REQUIRED)
        String name,
        @NotNull
        @Schema(name = "calories", example = "110.5", description = "Калории", requiredMode = Schema.RequiredMode.REQUIRED)
        BigDecimal calories,
        @NotNull
        @Schema(name = "proteins", example = "11.5", description = "Белки", requiredMode = Schema.RequiredMode.REQUIRED)
        BigDecimal proteins,
        @NotNull
        @Schema(name = "fats", example = "23.7", description = "Жиры", requiredMode = Schema.RequiredMode.REQUIRED)
        BigDecimal fats,
        @NotNull
        @Schema(name = "carbohydrates", example = "110.5", description = "Углеводы", requiredMode = Schema.RequiredMode.REQUIRED)
        BigDecimal carbohydrates
) {
}
