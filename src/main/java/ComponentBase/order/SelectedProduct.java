package ComponentBase.order;

import ComponentBase.product.Product;

/**
 * Created by panit on 5/11/2016.
 */
public class SelectedProduct {
    private Product product;
    private int amount;

    public SelectedProduct(int amount, Product product) {
        this.amount = amount;
        this.product = product;
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
