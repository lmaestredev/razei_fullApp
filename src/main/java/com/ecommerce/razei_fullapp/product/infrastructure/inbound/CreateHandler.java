package com.ecommerce.razei_fullapp.product.infrastructure.inbound;

import com.ecommerce.razei_fullapp.product.application.useCase.CreateUseCase;
import com.ecommerce.razei_fullapp.product.domain.model.ErrorResponse;
import com.ecommerce.razei_fullapp.product.domain.model.ProductCommand;
import jakarta.validation.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CreateHandler {

    private final CreateUseCase createUseCase;
    private final ErrorHandler errorHandler;

    @Autowired
    public CreateHandler(CreateUseCase createUseCase, ErrorHandler errorHandler) {
        this.createUseCase = createUseCase;
        this.errorHandler = errorHandler;
    }

    public Mono<ServerResponse> create(ServerRequest request) {
        Mono<ProductCommand> product = request.bodyToMono(ProductCommand.class);

        return product.flatMap(toCreate -> createUseCase.create(toCreate))
                .flatMap(created -> ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .bodyValue(created))
                .onErrorResume(ConstraintViolationException.class, errorHandler::validationExceptionHandler);
    }
}
