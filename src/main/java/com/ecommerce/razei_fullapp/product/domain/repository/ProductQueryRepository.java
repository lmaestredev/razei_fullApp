package com.ecommerce.razei_fullapp.product.domain.repository;

import com.ecommerce.razei_fullapp.product.domain.model.ProductCommand;
import com.ecommerce.razei_fullapp.product.domain.model.ProductQuery;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ProductQueryRepository {
    Flux<ProductQuery> getAllProducts();

}
