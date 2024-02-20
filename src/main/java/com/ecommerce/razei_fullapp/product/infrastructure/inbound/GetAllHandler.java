package com.ecommerce.razei_fullapp.product.infrastructure.inbound;

import com.ecommerce.razei_fullapp.product.application.useCase.GetAllUseCase;
import com.ecommerce.razei_fullapp.product.domain.model.ProductQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
public class GetAllHandler {

    private final GetAllUseCase getAllUseCase;

    @Autowired
    public GetAllHandler(GetAllUseCase getAllUseCase) {
        this.getAllUseCase = getAllUseCase;
    }

    public Mono<ServerResponse> getAllProducts(ServerRequest serverRequest){
        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON)
                .body(getAllUseCase.GetAllProducts(), ProductQuery.class);
    }
    
}
