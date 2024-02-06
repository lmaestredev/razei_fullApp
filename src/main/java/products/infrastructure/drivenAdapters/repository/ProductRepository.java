package products.infrastructure.drivenAdapters.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import products.infrastructure.drivenAdapters.entity.Product;

public interface ProductRepository extends MongoRepository<Product,String> {
}
