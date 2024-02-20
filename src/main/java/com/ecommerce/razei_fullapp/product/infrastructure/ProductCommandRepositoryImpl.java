package com.ecommerce.razei_fullapp.product.infrastructure;

import com.ecommerce.razei_fullapp.product.domain.model.ProductCommand;
import com.ecommerce.razei_fullapp.product.domain.model.ProductQuery;
import com.ecommerce.razei_fullapp.product.domain.repository.ProductCommandRepository;
import com.ecommerce.razei_fullapp.product.infrastructure.outbound.entity.ProductEntity;
import com.ecommerce.razei_fullapp.product.infrastructure.outbound.mapper.ProductMapper;
import com.ecommerce.razei_fullapp.product.infrastructure.outbound.repository.ProductMongoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public class ProductCommandRepositoryImpl implements ProductCommandRepository {

    private final ProductMongoRepository productMongoRepository;
    private final ProductMapper productMapper;

    @Autowired
    public ProductCommandRepositoryImpl(ProductMongoRepository productMongoRepository, ProductMapper productMapper) {
        this.productMongoRepository = productMongoRepository;
        this.productMapper = productMapper;
    }

    @Override
    public Mono<ProductQuery> createProduct(ProductCommand productCommand) {
        ProductEntity productEntity = productMapper.commandToEntity(productCommand);
        return productMongoRepository.save(productEntity).map(
                productMapper::entityToQuery
        );
    }
}
