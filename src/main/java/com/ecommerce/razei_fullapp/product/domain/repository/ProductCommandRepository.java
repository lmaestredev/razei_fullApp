package com.ecommerce.razei_fullapp.product.domain.repository;

import com.ecommerce.razei_fullapp.product.domain.model.ProductCommand;
import reactor.core.publisher.Flux;

public interface ProductCommandRepository {
    Flux<ProductCommand> getAllProducts();
}
