package ru.meetup.calorie_counter.user.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.meetup.calorie_counter.user.dao.entity.UserEntity;
import ru.meetup.calorie_counter.user.web.dto.request.UserCreateDto;
import ru.meetup.calorie_counter.user.web.dto.response.UserDto;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(target = "id", source = "uuid")
    UserDto toUserDto(UserEntity user);

    @Mapping(target = "uuid", ignore = true)
    UserEntity toUserEntity(UserCreateDto userCreateDto);
}
