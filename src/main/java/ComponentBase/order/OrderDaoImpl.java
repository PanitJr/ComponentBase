package ComponentBase.order;

import ComponentBase.repository.OrderRepository;
import ComponentBase.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
 * Created by panit on 5/11/2016.
 */
@Repository
public class OrderDaoImpl implements OrderDao {

    @Autowired
    OrderRepository orderRepository;

    @Override
    public List<Order> getOrders() {
        return orderRepository.findAll();
    }

    @Override
    public List<Order> getOrderByCustomer(String id) {
        return orderRepository.findByCustomerId(id);
    }

    @Override
    public List<Order> getOrderByDate(Date date) {
        return orderRepository.findByOpenBefore(date);
    }

    @Override
    public List<Order> getOrderByConfirm(boolean confirm) {
        return orderRepository.getOrderByConfirmed(confirm);
    }

    @Override
    public List<Order> getOrderByPay(boolean pay) {
        return orderRepository.getOrderByPay(pay);
    }

    @Override
    public Order getOrder(String id) {
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
}
