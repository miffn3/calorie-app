package ru.meetup.calorie_counter.day.service;

import ru.meetup.calorie_counter.day.dao.entity.DayEntity;
import ru.meetup.calorie_counter.day.web.dto.response.DayDto;

import java.time.LocalDate;
import java.util.UUID;

public interface DayService {
    DayDto getDay(UUID userId, LocalDate date);

    void deleteDay(UUID userId, LocalDate date);

    DayEntity getOrCreateDay(UUID userId, LocalDate date);
}
