package com.ecommerce.razei_fullapp.product.infrastructure;

import com.ecommerce.razei_fullapp.product.domain.model.ProductCommand;
import com.ecommerce.razei_fullapp.product.domain.repository.ProductCommandRepository;
import com.ecommerce.razei_fullapp.product.infrastructure.outbound.mapper.ProductMapper;
import com.ecommerce.razei_fullapp.product.infrastructure.outbound.repository.ProductMongoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

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
    public Flux<ProductCommand> getAllProducts() {
        return productMongoRepository.findAll().map( product -> {
            return productMapper.entityToModel(product);
        });
    }
}
