package ru.meetup.calorie_counter.day.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.meetup.calorie_counter.day.dao.entity.DayEntity;

import java.time.LocalDate;
import java.util.Optional;
import java.util.UUID;

public interface DayRepository extends JpaRepository<DayEntity, UUID> {

    Optional<UUID> findIdByUserUuidAndDate(UUID userId, LocalDate date);

    Optional<DayEntity> findByUserUuidAndDate(UUID userId, LocalDate date);
}
