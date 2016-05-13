package ComponentBase.order;

import ComponentBase.image.Image;
import ComponentBase.user.User;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by panit on 5/11/2016.
 */
@Entity
@Document
public class Order {
    @Id
    private String id;
    private Date open;
    private Date close;
    private Set<SelectedProduct> selectedProducts = new HashSet<>();
    private double totalPrice;
    private String transportType;
    private double transportCost;
    private boolean confirmed;
    private Set<Image> tranferment = new HashSet<>();
    private boolean pay;
    private String customerId;

    public Order(){}
    public Order(Date open, Set<SelectedProduct> selectedProducts,String customerId,String transportType) {
        this.open = open;
        this.selectedProducts = selectedProducts;
        this.customerId = customerId;
        this.transportType= transportType;
    }

    public Set<Image> getImages() {
        return this.tranferment;
    }

    public void setImages(Set<Image> images) {
        this.tranferment = images;
    }

    public boolean isPay() {
        return pay;
    }

    public void setPay(boolean payment) {
        this.pay = payment;
    }

    public String getTransportType() {
        return transportType;
    }

    public void setTransportType(String transportType) {
        this.transportType = transportType;
    }

    public double getTransportCost() {
        return transportCost;
    }

    public void setTransportCost(double transportCost) {
        this.transportCost = transportCost;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getOpen() {
        return open;
    }

    public void setOpen(Date open) {
        this.open = open;
    }

    public Date getClose() {
        return close;
    }

    public void setClose(Date close) {
        this.close = close;
    }

    public Set<SelectedProduct> getSelectedProducts() {
        return selectedProducts;
    }

    public void setSelectedProducts(Set<SelectedProduct> selectedProducts) {
        this.selectedProducts = selectedProducts;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public boolean isConfirmed() {
        return confirmed;
    }

    public void setConfirmed(boolean confirmed) {
        this.confirmed = confirmed;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }
}
