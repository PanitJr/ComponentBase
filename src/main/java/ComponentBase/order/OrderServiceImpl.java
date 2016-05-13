package ComponentBase.order;

import ComponentBase.email.EmailSender;
import ComponentBase.repository.UserRepository;
import ComponentBase.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by panit on 5/11/2016.
 */
@Service
public class OrderServiceImpl implements OrderService{

    @Autowired
    OrderDao orderDao;
    @Override
    public List<Order> getOrders() {
        return orderDao.getOrders();
    }

    @Override
    public List<Order> getOrderByCustomer(String id) {
        return orderDao.getOrderByCustomer(id);
    }

    @Override
    public List<Order> getOrderByDate(Date date) {
        return orderDao.getOrderByDate(date);
    }

    @Override
    public List<Order> getOrderByConfirm(boolean confirm) {
        return orderDao.getOrderByConfirm(confirm);
    }

    @Override
    public List<Order> getOrderByPay(boolean pay) {
        return orderDao.getOrderByPay(pay);
    }

    @Override
    public Order getOrder(String id) {
        return orderDao.getOrder(id);
    }

    @Override
    public Order create(Order order) {
        Date date = new Date();
        order.setOpen(date);
        //OrderNotification();
        return orderDao.create(order);
    }

    @Override
    public Order update(Order order) {
        //OrderNotification();
        return orderDao.update(order);
    }

    @Override
    public Order delete(Order order) {
        return orderDao.delete(order);
    }

    @Autowired
    private UserRepository userRepository;
    @Override
    public Order setTotalCost(Order order) {

        User customer = userRepository.findOne(order.getCustomerId());
        double total = 0;
        if (customer.getRole().getRoleName().equals("admin")){
            for (SelectedProduct selectProduct: order.getSelectedProducts()) {
                total += selectProduct.getAmount()*selectProduct.getProduct().getPrice();
            }
        }
        else if(customer.getRole().getRoleName().equals("retailer")){
            for (SelectedProduct selectProduct: order.getSelectedProducts()) {
                total += selectProduct.getAmount()*selectProduct.getProduct().getPriceRetailer();
            }
        }
        else if(customer.getRole().getRoleName().equals("wholesaler")){
            for (SelectedProduct selectProduct: order.getSelectedProducts()) {
                total += selectProduct.getAmount()*selectProduct.getProduct().getPriceWholesaler();
            }
        }else {
            for (SelectedProduct selectProduct: order.getSelectedProducts()) {
                total += selectProduct.getAmount()*selectProduct.getProduct().getPrice();
            }
        }
        total += order.getTransportCost();
        order.setTotalPrice(total);
        //OrderNotification();
        return orderDao.update(order);
    }

    @Override
    public Order setTransportCost(Order order, double transportCost) {
        order.setTransportCost(transportCost);
        //OrderNotification();
        return orderDao.update(order);
    }

    @Override
    public Order setConfirmOrder(Order order, boolean confirm) {
        order.setConfirmed(confirm);
        //OrderNotification();
        return orderDao.update(order);
    }

    @Override
    public Order setConfirmPayment(Order order) {
        Date date = new Date();
        order.setClose(date);
        //OrderNotification();
        return orderDao.create(order);
    }

    @Autowired
    private EmailSender smtpMailSender;

    @Override
    public void OrderNotification(Order order) {

    }
}
