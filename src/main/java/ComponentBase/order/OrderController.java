package ComponentBase.order;

import ComponentBase.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by panit on 5/11/2016.
 */
@CrossOrigin
@RestController
public class OrderController {
    @Autowired
    OrderService orderService;

    @RequestMapping(value = "/order",method = RequestMethod.GET)
    public List<Order> getOrder(){return orderService.getOrders();}
}
