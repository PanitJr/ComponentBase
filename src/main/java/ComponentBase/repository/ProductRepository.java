package ComponentBase.repository;

import ComponentBase.product.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * Created by panit on 5/11/2016.
 */
public interface ProductRepository extends MongoRepository<Product, String> {
    Product findOne(String id);
    List<Product> findAll();
    List<Product> findByCategory(String category);
    List<Product> findByType(String type);
    List<Product> findByNameContaining(String name);
}
