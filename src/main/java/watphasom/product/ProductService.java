package watphasom.product;


import watphasom.content.Content;
import watphasom.image.Image;

import java.util.List;

/**
 * Created by panit on 5/16/2016.
 */

public interface ProductService {
    List<Product> findByCategory(String category);
    List<Product> findByType(String type);
    List<Product> findByNameContaining(String name);
    List<Product> getProducts();
    Product getProduct(String id);
    Product create(Product product);
    Product update(String id,Product product);
    Product delete(String id);
    Product addImage (Product product,Image image);
    Product addReview (String id, Content content);
}
