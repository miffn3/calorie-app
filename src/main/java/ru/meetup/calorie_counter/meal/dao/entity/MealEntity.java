package ru.meetup.calorie_counter.meal.dao.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import ru.meetup.calorie_counter.day.dao.entity.DayEntity;
import ru.meetup.calorie_counter.product.dao.entity.ProductEntity;

import java.util.Set;
import java.util.UUID;

@Data
@Entity(name = "meal")
public class MealEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID uuid;

    private String name;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "meal_product", joinColumns = @JoinColumn(name = "meal_uuid"),
            inverseJoinColumns = @JoinColumn(name = "product_uuid"))
    private Set<ProductEntity> products;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "day_uuid")
    private DayEntity day;
}
