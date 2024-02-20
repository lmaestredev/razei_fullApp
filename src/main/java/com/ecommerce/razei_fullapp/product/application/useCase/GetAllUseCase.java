package com.ecommerce.razei_fullapp.product.application.useCase;

import com.ecommerce.razei_fullapp.product.domain.model.ProductQuery;
import com.ecommerce.razei_fullapp.product.domain.repository.ProductQueryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
public class GetAllUseCase {

    private final ProductQueryRepository productQueryRepository;

    @Autowired
    public GetAllUseCase(ProductQueryRepository productQueryRepository) {
        this.productQueryRepository = productQueryRepository;
    }

    public Flux<ProductQuery> GetAllProducts(){
        return productQueryRepository.getAllProducts();
    }
}
