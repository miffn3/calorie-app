package ru.meetup.calorie_counter.product.service;

import ru.meetup.calorie_counter.product.dao.entity.ProductEntity;
import ru.meetup.calorie_counter.product.web.dto.request.ProductCreateDto;
import ru.meetup.calorie_counter.product.web.dto.request.ProductUpdateDto;
import ru.meetup.calorie_counter.product.web.dto.response.ProductDto;

import java.util.Set;
import java.util.UUID;

public interface ProductService {
    ProductDto createProduct(ProductCreateDto productCreateDto);

    ProductDto updateProduct(UUID uuid, ProductUpdateDto productUpdateDto);

    Set<ProductEntity> getProductEntitiesByIds(Set<UUID> uuids);
}
