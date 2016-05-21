package watphasom.order;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import watphasom.bankTranfer.BankTranfer;
import watphasom.transportation.Transportation;
import watphasom.user.User;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by panit on 5/19/2016.
 */

@Document
public class Order {
    @Id
    private String id;
    @CreatedDate
    Date Created;
    private boolean confirm;
    private boolean pay;
    @DBRef
    private BankTranfer bankTranfer;
    private double transportCost;
    @DBRef
    private Transportation transportation;
    @DBRef
    private User user;
    private Set<SelectedProduct> selectedProductSet = new HashSet<>();
    private double totalPrice;

    public Order(Set<SelectedProduct> selectedProductSet, User user) {
        this.selectedProductSet = selectedProductSet;
        this.user = user;
    }

    public Date getCreated() {
        return Created;
    }

    public void setCreated(Date created) {
        Created = created;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


    public boolean isConfirm() {
        return confirm;
    }

    public void setConfirm(boolean confirm) {
        this.confirm = confirm;
    }

    public boolean isPay() {
        return pay;
    }

    public void setPay(boolean pay) {
        this.pay = pay;
    }

    public BankTranfer getBankTranfer() {
        return bankTranfer;
    }

    public void setBankTranfer(BankTranfer bankTranfer) {
        this.bankTranfer = bankTranfer;
    }

    public double getTransportCost() {
        return transportCost;
    }

    public void setTransportCost(double transportCost) {
        this.transportCost = transportCost;
    }

    public Transportation getTransportation() {
        return transportation;
    }

    public void setTransportation(Transportation transportation) {
        this.transportation = transportation;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Set<SelectedProduct> getSelectedProductSet() {
        return selectedProductSet;
    }

    public void setSelectedProductSet(Set<SelectedProduct> selectedProductSet) {
        this.selectedProductSet = selectedProductSet;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

}
