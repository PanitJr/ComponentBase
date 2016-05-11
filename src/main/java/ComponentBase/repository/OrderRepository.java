package ComponentBase.repository;

import ComponentBase.order.Order;
import ComponentBase.user.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Date;
import java.util.List;

/**
 * Created by panit on 5/11/2016.
 */
public interface OrderRepository extends MongoRepository<Order, String> {
    List<Order> findByCustomer(User user);
    List<Order> findByOpenBefore(Date date);
    List<Order> getOrderByConfirmed(boolean confirm);
    List<Order> getOrderByPay(boolean pay);
}
