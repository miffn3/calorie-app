package ru.meetup.calorie_counter.product.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.validator.constraints.UUID;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.meetup.calorie_counter.product.service.ProductService;
import ru.meetup.calorie_counter.product.web.dto.request.ProductCreateDto;
import ru.meetup.calorie_counter.product.web.dto.request.ProductUpdateDto;
import ru.meetup.calorie_counter.product.web.dto.response.ProductDto;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/products")
public class ProductController {

    private final ProductService productService;

    @PostMapping(value = "/")
    public ProductDto createProduct(@RequestBody @Valid ProductCreateDto productCreateDto) {
        return productService.createProduct(productCreateDto);
    }

    @PatchMapping(value = "/{productId}")
    public ProductDto updateProduct(@RequestBody ProductUpdateDto productUpdateDto, @PathVariable @Valid @UUID String productId) {
        return productService.updateProduct(java.util.UUID.fromString(productId), productUpdateDto);
    }
}
