package watphasom.order;

import watphasom.user.User;

import java.util.Date;
import java.util.List;

/**
 * Created by panit on 5/19/2016.
 */
public interface OrderDao {
    List<Order> list ();
    Order getOne (String id);
    Order create(Order order);
    Order update(Order order);
    Order delete(Order order);
    List<Order> findByPay(boolean pay);
    List<Order> findByConfirm(boolean confirm);
    List<Order> findByUser(User user);
    List<Order> findByDateCreate(Date date);
}
