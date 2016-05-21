package watphasom.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import watphasom.repository.OrderRepository;
import watphasom.user.User;

import java.util.Date;
import java.util.List;

/**
 * Created by panit on 5/19/2016.
 */
@Repository
public class OrderDaoImpl implements OrderDao {

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public List<Order> list() {
        return orderRepository.findAll();
    }

    @Override
    public Order getOne(String id) {
        return orderRepository.findOne(id);
    }

    @Override
    public Order create(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public Order update(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public Order delete(Order order) {
        orderRepository.delete(order);
        order.setId(null);
        return order;
    }

    @Override
    public List<Order> findByPay(boolean pay) {
        return orderRepository.findByPay(pay);
    }

    @Override
    public List<Order> findByConfirm(boolean confirm) {
        return orderRepository.findByConfirm(confirm);
    }

    @Override
    public List<Order> findByUser(User user) {
        return orderRepository.findByUser(user);
    }

    @Override
    public List<Order> findByDateCreate(Date date) {
        return orderRepository.findByCreated(date);
    }
}
