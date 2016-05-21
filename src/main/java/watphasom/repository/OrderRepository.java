package watphasom.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import watphasom.order.Order;
import watphasom.user.User;

import java.util.Date;
import java.util.List;

/**
 * Created by panit on 5/19/2016.
 */
public interface OrderRepository extends MongoRepository<Order,String> {
    List<Order> findAll();
    List<Order> findByPay(boolean pay);
    List<Order> findByConfirm(boolean confirm);
    List<Order> findByUser(User user);
    List<Order> findByCreated(Date date);
}
