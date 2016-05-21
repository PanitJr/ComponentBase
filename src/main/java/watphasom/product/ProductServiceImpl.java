package watphasom.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import watphasom.content.Content;
import watphasom.content.ContentDao;
import watphasom.image.Image;
import watphasom.image.ImageUtil;

import java.util.List;

/**
 * Created by panit on 5/16/2016.
 */
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductDao productDao;
    @Autowired
    ContentDao contentDao;

    @Override
    public List<Product> findByCategory(String category) {
        return productDao.findByCategory(category);
    }

    @Override
    public List<Product> findByType(String type) {
        return productDao.findByType(type);
    }

    @Override
    public List<Product> findByNameContaining(String name) {
        return productDao.findByNameContaining(name);
    }

    @Override
    public List<Product> getProducts() {
        return productDao.getProducts();
    }

    @Override
    public Product getProduct(String id) {
        return productDao.getProduct(id);
    }

    @Override
    public Product create(Product product) {
        return productDao.create(product);
    }

    @Override
    public Product update(String id, Product product) {
        return productDao.update(product);
    }

    @Override
    public Product delete(String id) {
        return productDao.delete(productDao.getProduct(id));
    }
    @Override
    @Transactional
    public Product addImage(Product product, Image image) {
        image= ImageUtil.resizeImage(image);
        product.getImages().add(image);
        productDao.update(product);
        return product;
    }

    @Override
    public Product addReview(String id, Content content) {
        contentDao.create(content);
        Product product = productDao.getProduct(id);
        product.getReviews().add(content);
        return productDao.update(product);
    }
}
