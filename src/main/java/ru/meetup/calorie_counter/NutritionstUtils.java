package ru.meetup.calorie_counter;

import ru.meetup.calorie_counter.product.dao.entity.ProductEntity;

import java.math.BigDecimal;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class NutritionstUtils {

    public static BigDecimal getCarbohydrates(Supplier<Stream<ProductEntity>> productsStreamSupplier) {
        return productsStreamSupplier.get()
                .map(ProductEntity::getCarbohydrates)
                .reduce(BigDecimal::add)
                .orElse(BigDecimal.ZERO);
    }

    public static BigDecimal getFats(Supplier<Stream<ProductEntity>> productsStreamSupplier) {
        return productsStreamSupplier.get()
                .map(ProductEntity::getFats)
                .reduce(BigDecimal::add)
                .orElse(BigDecimal.ZERO);
    }

    public static BigDecimal getProteins(Supplier<Stream<ProductEntity>> productsStreamSupplier) {
        return productsStreamSupplier.get()
                .map(ProductEntity::getProteins)
                .reduce(BigDecimal::add)
                .orElse(BigDecimal.ZERO);
    }

    public static BigDecimal getCalories(Supplier<Stream<ProductEntity>> productsStreamSupplier) {
        return productsStreamSupplier.get()
                .map(ProductEntity::getCalories)
                .reduce(BigDecimal::add)
                .orElse(BigDecimal.ZERO);
    }
}
