package ru.meetup.calorie_counter.user.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.meetup.calorie_counter.user.dao.entity.UserEntity;

import java.util.UUID;

public interface UserRepository extends JpaRepository<UserEntity, UUID> {
}
