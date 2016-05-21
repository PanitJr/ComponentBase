package watphasom.product;


import java.util.List;

/**
 * Created by panit on 5/16/2016.
 */

public interface ProductDao {
    List<Product> findByCategory(String category);
    List<Product> findByType(String type);
    List<Product> findByNameContaining(String name);
    List<Product> getProducts();
    Product getProduct(String id);
    Product create(Product product);
    Product update(Product product);
    Product delete(Product product);

}
