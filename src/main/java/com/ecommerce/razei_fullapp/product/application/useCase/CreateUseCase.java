package com.ecommerce.razei_fullapp.product.application.useCase;

import com.ecommerce.razei_fullapp.product.domain.model.ProductCommand;
import com.ecommerce.razei_fullapp.product.domain.model.ProductQuery;
import com.ecommerce.razei_fullapp.product.domain.repository.ProductCommandRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Mono;

@Service
@Validated
public class CreateUseCase {

    private final ProductCommandRepository productCommandRepository;

    @Autowired
    public CreateUseCase(ProductCommandRepository productCommandRepository) {
        this.productCommandRepository = productCommandRepository;
    }

    public Mono<ProductQuery> create(@Valid ProductCommand productCommand){
        return productCommandRepository.createProduct(productCommand);
    }
}
