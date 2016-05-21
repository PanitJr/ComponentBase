package watphasom.order;

import watphasom.image.Image;
import watphasom.transportation.Transportation;
import watphasom.transportation.TransportationType;
import watphasom.user.User;

import java.util.Date;
import java.util.List;

/**
 * Created by panit on 5/19/2016.
 */
public interface OrderService {
    List<Order> list ();
    Order getOne (String id);
    Order create(Order order);
    Order update(Order order);
    Order delete(String id);
    List<Order> findByPay(boolean pay);
    List<Order> findByConfirm(boolean confirm);
    List<Order> findByUser(User user);
    List<Order> findByDateCreate(Date date);
    Order makePayment(Order order,Image image);
    List<TransportationType> getTransportationType();
}
