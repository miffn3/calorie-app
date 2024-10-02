package ru.meetup.calorie_counter.day.dao.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.meetup.calorie_counter.meal.dao.entity.MealEntity;
import ru.meetup.calorie_counter.user.dao.entity.UserEntity;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "day")
public class DayEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID uuid;
    private LocalDate date;

    @OneToMany(fetch = FetchType.EAGER, orphanRemoval = true)
    @JoinColumn(name = "day_uuid")
    private List<MealEntity> meals;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_uuid")
    private UserEntity user;
}
