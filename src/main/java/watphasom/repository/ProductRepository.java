package watphasom.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import watphasom.product.Product;

import java.util.List;

/**
 * Created by panit on 5/16/2016.
 */
public interface ProductRepository extends MongoRepository<Product,String>{
    List<Product> findByNameContaining(String name);
    Product findOne(String id);
    List<Product> findByCategory(String category);
    List<Product> findByType(String type);
}
