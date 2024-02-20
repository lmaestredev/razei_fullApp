package com.ecommerce.razei_fullapp.product.infrastructure;

import com.ecommerce.razei_fullapp.product.domain.model.ProductCommand;
import com.ecommerce.razei_fullapp.product.domain.model.ProductQuery;
import com.ecommerce.razei_fullapp.product.domain.repository.ProductQueryRepository;
import com.ecommerce.razei_fullapp.product.infrastructure.outbound.entity.ProductEntity;
import com.ecommerce.razei_fullapp.product.infrastructure.outbound.mapper.ProductMapper;
import com.ecommerce.razei_fullapp.product.infrastructure.outbound.repository.ProductMongoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public class ProductQueryRepositoryImpl implements ProductQueryRepository {

    private final ProductMongoRepository productMongoRepository;
    private final ProductMapper productMapper;

    @Autowired
    public ProductQueryRepositoryImpl(ProductMongoRepository productMongoRepository, ProductMapper productMapper) {
        this.productMongoRepository = productMongoRepository;
        this.productMapper = productMapper;
    }

    @Override
    public Flux<ProductQuery> getAllProducts() {
        return productMongoRepository.findAll()
                .map(productMapper::entityToQuery);
    }
}
