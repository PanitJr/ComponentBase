package ComponentBase.product;

import ComponentBase.image.Image;

import java.util.List;

/**
 * Created by panit on 5/11/2016.
 */

public interface ProductService {
    List<Product> getProducts();
    Product create(Product product);
    Product edit(Product product);
    Product delete(String id);
    Product getProduct(String id);
    List<Product> findByCategory(String category);
    List<Product> findByType(String type);
    List<Product> findByName(String name);
    Product addImage(Product product, Image image);
}
