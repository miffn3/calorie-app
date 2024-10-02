package ru.meetup.calorie_counter.meal.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import ru.meetup.calorie_counter.NutritionstUtils;
import ru.meetup.calorie_counter.meal.dao.entity.MealEntity;
import ru.meetup.calorie_counter.meal.web.dto.request.MealCreateDto;
import ru.meetup.calorie_counter.meal.web.dto.request.MealUpdateDto;
import ru.meetup.calorie_counter.meal.web.dto.response.MealDto;
import ru.meetup.calorie_counter.product.dao.entity.ProductEntity;

import java.math.BigDecimal;
import java.util.Set;
import java.util.UUID;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface MealMapper {

    @Mapping(target = "uuid", ignore = true)
    @Mapping(target = "day", ignore = true)
    @Mapping(target = "products", ignore = true)
    void updateEntity(@MappingTarget MealEntity mealEntity, MealUpdateDto mealUpdateDto);

    default MealDto toDto(MealEntity entity) {
        Supplier<Stream<ProductEntity>> productsStreamSupplier = productsStreamSupplier(entity);

        BigDecimal calories = NutritionstUtils.getCalories(productsStreamSupplier);
        BigDecimal proteins = NutritionstUtils.getProteins(productsStreamSupplier);
        BigDecimal fats = NutritionstUtils.getFats(productsStreamSupplier);
        BigDecimal carbohydrates = NutritionstUtils.getCarbohydrates(productsStreamSupplier);

        Set<UUID> productIds = getProductIds(entity);

        return new MealDto(entity.getUuid(), entity.getName(), calories, proteins, fats, carbohydrates, productIds);
    }

    default Set<UUID> getProductIds(MealEntity entity) {
        return entity.getProducts().stream()
                .map(ProductEntity::getUuid)
                .collect(Collectors.toSet());
    }


    default Supplier<Stream<ProductEntity>> productsStreamSupplier(MealEntity entity) {
        return () -> entity.getProducts()
                .stream();
    }

    @Mapping(target = "uuid", ignore = true)
    @Mapping(target = "day", ignore = true)
    @Mapping(target = "products", ignore = true)
    MealEntity toEntity(MealCreateDto mealCreateDto);
}
