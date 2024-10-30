package ru.meetup.calorie_counter.day.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.meetup.calorie_counter.day.dao.entity.DayEntity;
import ru.meetup.calorie_counter.day.dao.repository.DayRepository;
import ru.meetup.calorie_counter.day.mapper.DayMapper;
import ru.meetup.calorie_counter.day.service.impl.DayServiceImpl;
import ru.meetup.calorie_counter.day.web.dto.response.DayDto;
import ru.meetup.calorie_counter.user.service.UserService;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class DayServiceTest {

    @Mock
    DayRepository dayRepository;

    @Mock
    UserService userService;

    @Spy
    DayMapper dayMapper;

    @InjectMocks
    DayServiceImpl dayService;

    @Test
    void getDay() {
        //given:
        UUID uuid = Mockito.mock(UUID.class);
        UUID dayUuid = Mockito.mock(UUID.class);
        LocalDate date = LocalDate.of(2024, 10, 30);
        DayEntity dayEntity = new DayEntity(dayUuid, date, List.of(), null);
        when(dayRepository.findByUserUuidAndDate(uuid, date)).thenReturn(Optional.of(dayEntity));

        //when:
        DayDto day = dayService.getDay(uuid, date);

        //then:
        assertEquals(dayUuid, day.id());
        assertEquals(date, day.date());
    }
}