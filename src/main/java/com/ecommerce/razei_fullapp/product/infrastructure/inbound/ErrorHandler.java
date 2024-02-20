package com.ecommerce.razei_fullapp.product.infrastructure.inbound;

import com.ecommerce.razei_fullapp.product.domain.model.ErrorResponse;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ErrorHandler {

    public Mono<ServerResponse> validationExceptionHandler(ConstraintViolationException ex) {
        List<String> errorDetails = ex.getConstraintViolations().stream()
                .map(violation -> String.format(violation.getMessageTemplate()))
                .collect(Collectors.toList());

        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setError("Validation errors");
        errorResponse.setData(errorDetails);
        errorResponse.setCode(400);

        return ServerResponse.badRequest()
                .contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromValue(errorResponse));

    }
}
