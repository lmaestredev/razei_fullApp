package com.ecommerce.razei_fullapp.product.infrastructure.outbound.repository;

import com.ecommerce.razei_fullapp.product.infrastructure.outbound.entity.ProductEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface ProductMongoRepository extends ReactiveMongoRepository<ProductEntity,String> {
}
