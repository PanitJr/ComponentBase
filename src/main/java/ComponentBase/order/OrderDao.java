package ComponentBase.order;

import ComponentBase.user.User;
import com.sun.org.apache.xpath.internal.operations.Or;

import java.util.Date;
import java.util.List;

/**
 * Created by panit on 5/11/2016.
 */
public interface OrderDao {
    List<Order> getOrders();
    List<Order> getOrderByCustomer(User user);
    List<Order> getOrderByDate(Date date);
    List<Order> getOrderByConfirm(boolean confirm);
    List<Order> getOrderByPay(boolean pay);
    Order getOrder(String id);
    Order create(Order order);
    Order update(Order order);
    Order delete(Order order);

}
