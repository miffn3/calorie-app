package ru.meetup.calorie_counter.product.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import ru.meetup.calorie_counter.product.dao.entity.ProductEntity;
import ru.meetup.calorie_counter.product.web.dto.request.ProductCreateDto;
import ru.meetup.calorie_counter.product.web.dto.request.ProductUpdateDto;
import ru.meetup.calorie_counter.product.web.dto.response.ProductDto;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface ProductMapper {

    @Mapping(target = "id", source = "uuid")
    ProductDto toDto(ProductEntity entity);

    @Mapping(target = "uuid", ignore = true)
    ProductEntity toEntity(ProductCreateDto productCreateDto);

    @Mapping(target = "uuid", ignore = true)
    void updateEntity(@MappingTarget ProductEntity entity, ProductUpdateDto productUpdateDto);
}
