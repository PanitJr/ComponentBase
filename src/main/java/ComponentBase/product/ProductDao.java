package ComponentBase.product;


import java.util.List;

/**
 * Created by panit on 5/11/2016.
 */
public interface ProductDao {
   List<Product> getProducts();
    Product create(Product product);
    Product edit(Product product);
    Product delete(Product product);
    Product getProduct(String id);
    List<Product> findByCategory(String category);
    List<Product> findByType(String type);
    List<Product> findByName(String name);
}
