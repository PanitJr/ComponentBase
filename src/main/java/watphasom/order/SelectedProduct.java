package watphasom.order;

import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import watphasom.product.Product;

/**
 * Created by panit on 5/19/2016.
 */
public class SelectedProduct {
    @DBRef
    private Product product;
    private int amount;

    public SelectedProduct() {
    }

    public SelectedProduct(Product product, int amount) {
        this.product = product;
        this.amount = amount;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
