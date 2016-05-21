package watphasom.order;

import com.sun.org.apache.xpath.internal.operations.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import watphasom.bankTranfer.BankTranfer;
import watphasom.bankTranfer.BankTranferDao;
import watphasom.image.Image;
import watphasom.image.ImageUtil;
import watphasom.product.Product;
import watphasom.repository.TransportationTypeRepository;
import watphasom.role.RoleDao;
import watphasom.transportation.Transportation;
import watphasom.transportation.TransportationDao;
import watphasom.transportation.TransportationType;
import watphasom.transportation.TransportationTypeDao;
import watphasom.user.Message;
import watphasom.user.User;

import java.util.Date;
import java.util.List;

/**
 * Created by panit on 5/19/2016.
 */
@Service
public class OrderServiceImpl implements OrderService{
    @Autowired
    OrderDao orderDao;
    @Autowired
    TransportationDao transportationDao;
    @Autowired
    TransportationTypeDao transportationTypeDao;
    @Autowired
    BankTranferDao bankTranferDao;
    @Autowired
    RoleDao roleDao;

    @Override
    public List<Order> list() {
        return orderDao.list();
    }

    @Override
    public Order getOne(String id) {
        return orderDao.getOne(id);
    }

    @Override
    public Order create(Order order) {
        order.setTransportation(transportationDao.create(new Transportation(
                transportationTypeDao.findByName(order.getTransportation().getType().getName()))));
        return orderDao.create(order);
    }

    @Override
    public Order update(Order order) {
        order.getUser().getMessages().add(new Message("Order update","your Order has been updated. " +
                "Please check your order for your benefit."));
        order.setTotalPrice(getTotalPrice(order));
        return orderDao.update(order);
    }

    @Override
    public Order delete(String id) {
        return orderDao.delete(orderDao.getOne(id));
    }

    @Override
    public List<Order> findByPay(boolean pay) {
        return orderDao.findByPay(pay);
    }

    @Override
    public List<Order> findByConfirm(boolean confirm) {
        return orderDao.findByConfirm(confirm);
    }

    @Override
    public List<Order> findByUser(User user) {
        return orderDao.findByUser(user);
    }

    @Override
    public List<Order> findByDateCreate(Date date) {
        return orderDao.findByDateCreate(date);
    }

    @Override
    @Transactional
    public Order makePayment(Order order,Image image) {
        image= ImageUtil.resizeImage(image);
        order.setBankTranfer(bankTranferDao.create(new BankTranfer(image)));
        return orderDao.update(order);
    }

    @Override
    public List<TransportationType> getTransportationType() {
        return transportationTypeDao.findAll();
    }

    public double getTotalPrice(Order order){
        double totalprice = 0.0;
        for (SelectedProduct s: order.getSelectedProductSet()) {
            if(order.getUser().getRoles().contains(roleDao.getByRoleName("wholesaler"))){
            totalprice+=s.getAmount()*s.getProduct().getWholesalePrice();}
            else if (order.getUser().getRoles().contains(roleDao.getByRoleName("retailer"))){
                totalprice+=s.getAmount()*s.getProduct().getRetailPrice();
            }else totalprice+=s.getAmount()*s.getProduct().getPrice();
        }
        totalprice+=order.getTransportCost();
        return totalprice;
    }
}
