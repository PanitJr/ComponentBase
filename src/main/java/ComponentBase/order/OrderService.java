package ComponentBase.order;

import ComponentBase.image.Image;
import ComponentBase.product.Product;
import ComponentBase.user.User;

import java.util.Date;
import java.util.List;

/**
 * Created by panit on 5/11/2016.
 */
public interface OrderService {
    List<Order> getOrders();
    List<Order> getOrderByCustomer(String id);
    List<Order> getOrderByDate(Date date);
    List<Order> getOrderByConfirm(boolean confirm);
    List<Order> getOrderByPay(boolean pay);
    Order getOrder(String id);
    Order create(Order order);
    Order update(Order order);
    Order delete(Order order);
    void setTotalCost(Order order);
    Order setTransportCost(Order order,double transportCost);
    Order setConfirmOrder(Order Order,boolean confirm);
    Order setConfirmPayment(Order order);
    Order addImage(Order order, Image image);

}
