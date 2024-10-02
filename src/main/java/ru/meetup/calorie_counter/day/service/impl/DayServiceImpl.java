package ru.meetup.calorie_counter.day.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.meetup.calorie_counter.day.dao.entity.DayEntity;
import ru.meetup.calorie_counter.day.dao.repository.DayRepository;
import ru.meetup.calorie_counter.day.exception.DayNotFoundException;
import ru.meetup.calorie_counter.day.mapper.DayMapper;
import ru.meetup.calorie_counter.day.service.DayService;
import ru.meetup.calorie_counter.day.web.dto.response.DayDto;
import ru.meetup.calorie_counter.user.dao.entity.UserEntity;
import ru.meetup.calorie_counter.user.service.UserService;

import java.time.LocalDate;
import java.util.UUID;

@Slf4j
@RequiredArgsConstructor
@Service
public class DayServiceImpl implements DayService {

    private final DayRepository dayRepository;
    private final UserService userService;
    private final DayMapper dayMapper;

    @Override
    public DayDto getDay(UUID userId, LocalDate date) {
        DayEntity entity = dayRepository.findByUserUuidAndDate(userId, date)
                .orElseThrow(
                        () -> new DayNotFoundException("Day " + date + " not found")
                );

        return dayMapper.toDto(entity);
    }

    @Transactional
    @Override
    public void deleteDay(UUID userId, LocalDate date) {
        UUID id = dayRepository.findIdByUserUuidAndDate(userId, date)
                .orElseThrow(
                        () -> new DayNotFoundException("Day " + date + " not found")
                );
        dayRepository.deleteById(id);
        log.info("Day {} was deleted", date);
    }

    @Override
    public DayEntity getOrCreateDay(UUID userId, LocalDate date) {
        return dayRepository.findByUserUuidAndDate(userId, date)
                .orElseGet(() -> createDay(userId, date));
    }

    private DayEntity createDay(UUID userId, LocalDate date) {
        log.info("Create day {} for user {}", date, userId);
        UserEntity user = userService.getUserEntity(userId);
        return dayRepository.save(new DayEntity(null, date, null, user));
    }
}
