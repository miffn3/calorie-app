package ru.meetup.calorie_counter.product.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.meetup.calorie_counter.product.dao.entity.ProductEntity;
import ru.meetup.calorie_counter.product.dao.repository.ProductRepository;
import ru.meetup.calorie_counter.product.exception.ProductNotFoundException;
import ru.meetup.calorie_counter.product.mapper.ProductMapper;
import ru.meetup.calorie_counter.product.service.ProductService;
import ru.meetup.calorie_counter.product.web.dto.request.ProductCreateDto;
import ru.meetup.calorie_counter.product.web.dto.request.ProductUpdateDto;
import ru.meetup.calorie_counter.product.web.dto.response.ProductDto;

import java.util.Set;
import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    @Override
    public ProductDto createProduct(ProductCreateDto productCreateDto) {
        log.info("Product create: {}", productCreateDto);
        ProductEntity saved = productRepository.save(productMapper.toEntity(productCreateDto));
        return productMapper.toDto(saved);
    }

    @Override
    public ProductDto updateProduct(UUID id, ProductUpdateDto productUpdateDto) {
        log.info("Product with id = {} update: {}", id, productUpdateDto);
        ProductEntity entity = productRepository.findById(id).orElseThrow(() -> new ProductNotFoundException("Product with id = " + id + " not found"));
        productMapper.updateEntity(entity, productUpdateDto);
        return productMapper.toDto(entity);
    }

    @Override
    public Set<ProductEntity> getProductEntitiesByIds(Set<UUID> uuids) {
        return productRepository.findAllByUuidIn(uuids);
    }
}
