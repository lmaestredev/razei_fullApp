package com.ecommerce.razei_fullapp.product.infrastructure.inbound.useCaseHandler;

import com.ecommerce.razei_fullapp.product.application.useCase.CreateUseCase;
import com.ecommerce.razei_fullapp.product.domain.model.ProductCommand;
import com.ecommerce.razei_fullapp.product.infrastructure.outbound.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.net.URI;
@Service
public class CreateHandler {

    private final CreateUseCase createUseCase;
    private final ProductMapper productMapper;

    @Autowired
    public CreateHandler(CreateUseCase createUseCase, ProductMapper productMapper) {
        this.createUseCase = createUseCase;
        this.productMapper = productMapper;
    }

    public Mono<ServerResponse> create(ServerRequest request){
        Mono<ProductCommand> product = request.bodyToMono(ProductCommand.class);

        return product.flatMap( toCreate -> {
            return createUseCase.create(toCreate);
        }).flatMap(created ->
                ServerResponse
                        .created(URI.create("/api/v1/products/created"))
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(BodyInserters.fromObject(created))
        );
    }
}
