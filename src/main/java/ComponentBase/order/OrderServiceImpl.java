package ComponentBase.order;

import ComponentBase.email.EmailSender;
import ComponentBase.image.Image;
import ComponentBase.image.ImageUtil;
import ComponentBase.message.Message;
import ComponentBase.product.Product;
import ComponentBase.repository.RoleRepository;
import ComponentBase.repository.UserRepository;
import ComponentBase.role.Role;
import ComponentBase.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by panit on 5/11/2016.
 */
@Service
public class OrderServiceImpl implements OrderService{

    @Autowired
    OrderDao orderDao;

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;

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
        User user = userRepository.findOne(order.getCustomerId());
        Message message = new Message("New Order","New Order was created by User id: "+user.getUsername());
        user.getMessages().add(message);
        userRepository.save(user);
        Set<Role> roles = new HashSet<>();
        roles.add(roleRepository.findByRoleName("admin"));
        List<User> admins = userRepository.findByRoles(roles);
        for (User admin : admins) {
            admin.getMessages().add(message);
            userRepository.save(admin);
        }
        return orderDao.create(order);
    }

    @Override
    public Order update(Order order) {
        return orderDao.update(order);
    }

    @Override
    public Order delete(Order order) {
        return orderDao.delete(order);
    }


    @Override
    public void setTotalCost(Order order) {

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
        }
        else {
            for (SelectedProduct selectProduct: order.getSelectedProducts()) {
                total += selectProduct.getAmount()*selectProduct.getProduct().getPrice();
            }
        }
        total += order.getTransportCost();
        order.setTotalPrice(total);
    }

    @Override
    public Order setTransportCost(Order order, double transportCost) {
        User user = userRepository.findOne(order.getCustomerId());
        Message message = new Message("Order On "+order.getOpen()+"was set transport cost","Your order " +
                "is set the transport cost see detail and confirm your order for continue, " +
                "After you confirm you can make payment for this order");
        user.getMessages().add(message);
        userRepository.save(user);
        order.setTransportCost(transportCost);
        setTotalCost(order);

        return orderDao.update(order);
    }

    @Override
    public Order setConfirmOrder(Order order, boolean confirm) {
        order.setConfirmed(confirm);
        User user = userRepository.findOne(order.getCustomerId());
        Message message = new Message("Order On "+order.getOpen()+"was confirmed","Make payment to continue");
        user.getMessages().add(message);
        userRepository.save(user);
        return orderDao.update(order);
    }

    @Override
    public Order setConfirmPayment(Order order) {
        Date date = new Date();
        order.setClose(date);
        User user = userRepository.findOne(order.getCustomerId());
        Message message = new Message("Order On "+order.getOpen()+"was paid","Wait for transportation");
        user.getMessages().add(message);
        userRepository.save(user);
        return orderDao.create(order);
    }


    @Override
    public Order addImage(Order order, Image image) {
        image= ImageUtil.resizeImage(image,200);
        order.getImages().add(image);
        orderDao.update(order);
        Message message = new Message("Order Paid: " +order.getId(),"Order paid by Customer money tranfer " +
                "please confirm payment for your customer");
        Set<Role> roles = new HashSet<>();
        roles.add(roleRepository.findByRoleName("admin"));
        List<User> admins = userRepository.findByRoles(roles);
        for (User admin : admins) {
            admin.getMessages().add(message);
            userRepository.save(admin);
        }
        return order;
    }

}
