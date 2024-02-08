package com.ecommerce.razei_fullapp.product.domain.repository;

import com.ecommerce.razei_fullapp.product.domain.model.ProductQuery;
import reactor.core.publisher.Mono;

public interface ProductQueryRepository {
    Mono<ProductQuery> createProduct(ProductQuery productQuery);

}
