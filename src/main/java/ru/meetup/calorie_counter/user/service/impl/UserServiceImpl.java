package ru.meetup.calorie_counter.user.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.meetup.calorie_counter.user.dao.entity.UserEntity;
import ru.meetup.calorie_counter.user.dao.repository.UserRepository;
import ru.meetup.calorie_counter.user.exception.UserAlreadyExistException;
import ru.meetup.calorie_counter.user.exception.UserNotFoundException;
import ru.meetup.calorie_counter.user.mapper.UserMapper;
import ru.meetup.calorie_counter.user.service.UserService;
import ru.meetup.calorie_counter.user.web.dto.request.UserCreateDto;
import ru.meetup.calorie_counter.user.web.dto.response.UserDto;

import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public UserDto getUser(UUID userId) {
        log.info("Get user by id {}", userId);
        var user = userRepository.findById(userId).orElseThrow(() -> new UserNotFoundException("User not found"));
        return userMapper.toUserDto(user);
    }

    @Override
    public UserDto createUser(UserCreateDto userCreateDto) {
        log.info("Create user {}", userCreateDto);
        //FIXME: there is no possibility to create more than one user
        if (userRepository.count() > 0) {
            throw new UserAlreadyExistException("User already exist");
        }

        UserEntity saved = userRepository.save(userMapper.toUserEntity(userCreateDto));
        return userMapper.toUserDto(saved);
    }

    @Override
    public UserEntity getUserEntity(UUID userId) {
        return userRepository.findById(userId).orElseThrow(() -> new UserNotFoundException("User not found"));
    }
}
