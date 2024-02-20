package com.ecommerce.razei_fullapp.product.infrastructure.config;

import com.ecommerce.razei_fullapp.product.infrastructure.inbound.CreateHandler;
import com.ecommerce.razei_fullapp.product.infrastructure.inbound.GetAllHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RouterFunctions.route;
import static org.springframework.web.reactive.function.server.RequestPredicates.*;

@Configuration
public class RouterFunctionConfig {

    private static String baseUri = "/api/v1/products";

    @Bean
    public RouterFunction<ServerResponse> getAll(GetAllHandler getAllHandler){
        return route(GET(baseUri+"/get-all"), getAllHandler::getAllProducts);
    }

    @Bean
    public RouterFunction<ServerResponse> create(CreateHandler handler){
        return RouterFunctions.route(POST(baseUri+"/create")
                .and(RequestPredicates.accept(MediaType.APPLICATION_JSON)),
                handler::create);
    }
}
