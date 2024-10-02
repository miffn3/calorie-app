package ru.meetup.calorie_counter.day.mapper;

import org.mapstruct.Mapper;
import ru.meetup.calorie_counter.NutritionstUtils;
import ru.meetup.calorie_counter.day.dao.entity.DayEntity;
import ru.meetup.calorie_counter.day.web.dto.response.DayDto;
import ru.meetup.calorie_counter.meal.dao.entity.MealEntity;
import ru.meetup.calorie_counter.product.dao.entity.ProductEntity;

import java.math.BigDecimal;
import java.util.Set;
import java.util.UUID;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Mapper(componentModel = "spring")
public interface DayMapper {

    default DayDto toDto(DayEntity entity) {
        Supplier<Stream<ProductEntity>> productsStreamSupplier = productsStreamSupplier(entity);

        BigDecimal calories = NutritionstUtils.getCalories(productsStreamSupplier);
        BigDecimal proteins = NutritionstUtils.getProteins(productsStreamSupplier);
        BigDecimal fats = NutritionstUtils.getFats(productsStreamSupplier);
        BigDecimal carbohydrates = NutritionstUtils.getCarbohydrates(productsStreamSupplier);

        Set<UUID> mealIds = getMealIds(entity);

        return new DayDto(entity.getUuid(), entity.getDate(), calories, proteins, fats, carbohydrates, mealIds);
    }

    default Set<UUID> getMealIds(DayEntity entity) {
        return entity.getMeals().stream()
                .map(MealEntity::getUuid)
                .collect(Collectors.toSet());
    }

    private static Supplier<Stream<ProductEntity>> productsStreamSupplier(DayEntity entity) {
        return () -> entity.getMeals()
                .stream()
                .map(MealEntity::getProducts)
                .flatMap(Set::stream);
    }
}
