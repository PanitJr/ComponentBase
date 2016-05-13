package ComponentBase.product;

import ComponentBase.image.Image;
import ComponentBase.image.ImageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by panit on 5/11/2016.
 */
@Service
public class ProductServiceImpl implements ProductService{
    @Autowired
    ProductDao productDao;

    @Override
    public List<Product> getProducts() {
        return productDao.getProducts();
    }

    @Override
    public Product create(Product product) {
        return productDao.create(product);
    }

    @Override
    public Product edit(Product product) {
        return productDao.edit(product);
    }

    @Override
    public Product delete(String id) {
        Product product = productDao.getProduct(id);
        return productDao.delete(product);
    }

    @Override
    public Product getProduct(String id) {
        return productDao.getProduct(id);
    }

    @Override
    public List<Product> findByCategory(String category) {
        return productDao.findByCategory(category);
    }

    @Override
    public List<Product> findByType(String type) {
        return productDao.findByType(type);
    }

    @Override
    public List<Product> findByName(String name) {
        return productDao.findByName(name);
    }

    @Override
    public Product addImage(Product product, Image image) {
        image= ImageUtil.resizeImage(image,200);
        product.getImages().add(image);
        productDao.edit(product);
        return product;
    }
}
