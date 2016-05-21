package watphasom.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import watphasom.email.EmailSender;
import watphasom.image.Image;
import watphasom.transportation.TransportationType;
import watphasom.user.User;
import watphasom.user.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 * Created by panit on 5/19/2016.
 */
@RestController
@CrossOrigin
public class OrderController {
    @Autowired
    OrderService orderService;
    @Autowired
    UserService userService;

    @RequestMapping(value = "/order/pay",method = RequestMethod.POST)
    @ResponseBody
    public Order addImage(HttpServletRequest request,
                            HttpServletResponse response, @RequestParam("orderid")String orderid){
        MultipartHttpServletRequest mRequest;
        Order order = orderService.getOne(orderid);
        try{
            mRequest = (MultipartHttpServletRequest)request;
            Iterator<String> itr= mRequest.getFileNames();
            while(itr.hasNext()){
                MultipartFile multipartFile = mRequest.getFile(itr.next());
                Image image = new Image();
                image.setFileName(multipartFile.getOriginalFilename());
                image.setContentType(multipartFile.getContentType());
                image.setContent(multipartFile.getBytes());
                image.setCreated(Calendar.getInstance().getTime());
                orderService.makePayment(order,image);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        userService.adminNotification("New Payment","New Paymeny for Order id"+ order.getId());
        return order;
    }
    @RequestMapping(value = "/order/search/{pay}",method = RequestMethod.GET)
    public List<Order> getOrderByPay(@PathVariable("pay")boolean pay){return orderService.findByPay(pay);}

    @RequestMapping(value = "/order/search/{confirm}",method = RequestMethod.GET)
    public List<Order> getOrderByConfirm(@PathVariable("confirm")boolean confirm){return orderService.findByConfirm(confirm);}

    @RequestMapping(value = "/order/search/{date}",method = RequestMethod.GET)
    public List<Order> getOrderByDate(@PathVariable("date")Date date){return orderService.findByDateCreate(date);}

    @RequestMapping(value = "/user/order",method = RequestMethod.POST)
    public List<Order> getOrderByUser(@RequestBody User user){return orderService.findByUser(user);}

    @RequestMapping(value = "/order",method = RequestMethod.GET)
    public List<Order> list (){return orderService.list();}

    @RequestMapping(value = "/order/{id}",method = RequestMethod.GET)
    public Order getOrder(@PathVariable("id")String id){return orderService.getOne(id);}

    @RequestMapping(value = "/order",method = RequestMethod.POST)
    public @ResponseBody Order create(@RequestBody Order order){
        userService.adminNotification("New Order","New order was created");
        return orderService.create(order);}

    @RequestMapping(value = "/order/{id}",method = RequestMethod.PUT)
    public @ResponseBody Order update(@PathVariable("id")String id,@RequestBody Order order){
        return orderService.update(order);
    }

    @RequestMapping(value = "/order/{id}",method = RequestMethod.DELETE)
    public @ResponseBody Order delete(@PathVariable("id")String id){
        return orderService.delete(id);
    }

    @RequestMapping(value = "/order/transportationtype",method = RequestMethod.GET)
    public List<TransportationType> getTransportationType (){return orderService.getTransportationType();}

}
