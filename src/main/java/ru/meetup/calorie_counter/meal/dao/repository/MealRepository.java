package ru.meetup.calorie_counter.meal.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.meetup.calorie_counter.meal.dao.entity.MealEntity;

import java.util.UUID;

public interface MealRepository extends JpaRepository<MealEntity, UUID> {
}
