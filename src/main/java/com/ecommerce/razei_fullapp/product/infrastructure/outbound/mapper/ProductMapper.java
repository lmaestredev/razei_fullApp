package com.ecommerce.razei_fullapp.product.infrastructure.outbound.mapper;

import com.ecommerce.razei_fullapp.product.domain.model.ProductCommand;
import com.ecommerce.razei_fullapp.product.domain.model.ProductQuery;
import com.ecommerce.razei_fullapp.product.infrastructure.outbound.entity.ProductEntity;
import org.mapstruct.Mapper;

@Mapper
public interface ProductMapper {

    ProductCommand entityToCommand(ProductEntity product);
    ProductEntity commandToEntity(ProductCommand product);
    ProductEntity queryToEntity(ProductQuery product);
    ProductQuery entityToQuery(ProductEntity product);

}
