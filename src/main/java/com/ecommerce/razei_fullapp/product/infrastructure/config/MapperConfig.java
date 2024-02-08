package com.ecommerce.razei_fullapp.product.infrastructure.config;

import org.mapstruct.factory.Mappers;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.ecommerce.razei_fullapp.product.infrastructure.outbound.mapper.ProductMapper;

@Configuration
public class MapperConfig {

    @Bean
    public ProductMapper productMapper() {
        return Mappers.getMapper(ProductMapper.class);
    }
}
