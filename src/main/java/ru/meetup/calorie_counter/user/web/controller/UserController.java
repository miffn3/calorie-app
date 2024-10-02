package ru.meetup.calorie_counter.user.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.validator.constraints.UUID;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.meetup.calorie_counter.user.service.UserService;
import ru.meetup.calorie_counter.user.web.dto.request.UserCreateDto;
import ru.meetup.calorie_counter.user.web.dto.response.UserDto;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/v1/users")
public class UserController {

    private final UserService userService;

    @GetMapping(value = "/{userId}")
    public UserDto getUser(@PathVariable @Valid @UUID String userId) {
        return userService.getUser(java.util.UUID.fromString(userId));
    }

    @PostMapping(value = "/")
    public UserDto createUser(@RequestBody @Valid UserCreateDto userCreateDto) {
        return userService.createUser(userCreateDto);
    }

    //UPDATE
}
