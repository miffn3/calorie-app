package ru.meetup.calorie_counter.product.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.meetup.calorie_counter.product.dao.entity.ProductEntity;

import java.util.Set;
import java.util.UUID;

public interface ProductRepository extends JpaRepository<ProductEntity, UUID> {

    Set<ProductEntity> findAllByUuidIn(Set<UUID> uuids);
}
