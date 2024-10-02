package ru.meetup.calorie_counter.user.service;

import ru.meetup.calorie_counter.user.dao.entity.UserEntity;
import ru.meetup.calorie_counter.user.web.dto.request.UserCreateDto;
import ru.meetup.calorie_counter.user.web.dto.response.UserDto;

import java.util.UUID;

public interface UserService {
    UserDto getUser(UUID userId);

    UserDto createUser(UserCreateDto userCreateDto);

    UserEntity getUserEntity(UUID userId);
}
