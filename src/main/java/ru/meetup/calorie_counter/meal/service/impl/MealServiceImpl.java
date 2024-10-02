package ru.meetup.calorie_counter.meal.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.meetup.calorie_counter.day.dao.entity.DayEntity;
import ru.meetup.calorie_counter.day.service.DayService;
import ru.meetup.calorie_counter.meal.dao.entity.MealEntity;
import ru.meetup.calorie_counter.meal.dao.repository.MealRepository;
import ru.meetup.calorie_counter.meal.exception.MealNotFoundException;
import ru.meetup.calorie_counter.meal.mapper.MealMapper;
import ru.meetup.calorie_counter.meal.service.MealService;
import ru.meetup.calorie_counter.meal.web.dto.request.MealCreateDto;
import ru.meetup.calorie_counter.meal.web.dto.request.MealUpdateDto;
import ru.meetup.calorie_counter.meal.web.dto.response.MealDto;
import ru.meetup.calorie_counter.product.dao.entity.ProductEntity;
import ru.meetup.calorie_counter.product.service.ProductService;
import ru.meetup.calorie_counter.user.service.UserService;
import ru.meetup.calorie_counter.user.web.dto.response.UserDto;

import java.time.LocalDate;
import java.util.Set;
import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class MealServiceImpl implements MealService {

    private final UserService userService;
    private final DayService dayService;
    private final ProductService productService;
    private final MealRepository mealRepository;
    private final MealMapper mealMapper;

    @Override
    public MealDto createMeal(UUID userId, LocalDate date, MealCreateDto mealCreateDto) {
        UserDto user = userService.getUser(userId);

        MealEntity mealEntity = mealMapper.toEntity(mealCreateDto);
        updateDay(date, user.id(), mealEntity);
        updateProducts(mealCreateDto.productIds(), mealEntity);

        MealEntity saved = mealRepository.save(mealEntity);

        return mealMapper.toDto(saved);
    }

    private void updateDay(LocalDate date, UUID userId, MealEntity mealEntity) {
        DayEntity dayEntity = dayService.getOrCreateDay(userId, date);
        mealEntity.setDay(dayEntity);
    }

    private void updateProducts(Set<UUID> mealCreateDto, MealEntity mealEntity) {
        Set<ProductEntity> productEntities = productService.getProductEntitiesByIds(mealCreateDto);
        mealEntity.setProducts(productEntities);
    }

    @Override
    public void deleteMeal(UUID mealId) {
        mealRepository.deleteById(mealId);
    }

    @Override
    public MealDto updateMeal(UUID mealId, MealUpdateDto mealUpdateDto) {
        MealEntity mealEntity = mealRepository.findById(mealId).orElseThrow(
                () -> new MealNotFoundException("Meal with id " + mealId + "not found")
        );
        mealMapper.updateEntity(mealEntity, mealUpdateDto);
        updateProducts(mealUpdateDto.productIds(), mealEntity);
        MealEntity saved = mealRepository.save(mealEntity);

        return mealMapper.toDto(saved);
    }

    @Override
    public MealDto getMeal(UUID mealId) {
        MealEntity entity = mealRepository.findById(mealId)
                .orElseThrow(
                        () -> new MealNotFoundException("Meal with id " + mealId + "not found")
                );

        return mealMapper.toDto(entity);
    }
}
