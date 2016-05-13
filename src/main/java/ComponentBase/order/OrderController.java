package ComponentBase.order;

import ComponentBase.image.Image;
import ComponentBase.product.Product;
import ComponentBase.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Calendar;
import java.util.Iterator;
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

    @RequestMapping(value = "/order/{id}",method = RequestMethod.GET)
    public Order getOrder(@PathVariable("id")String id){return orderService.getOrder(id);}

    @RequestMapping(value = "/order",method = RequestMethod.POST)
    public @ResponseBody Order getOrder(@RequestBody Order order , BindingResult bindingResult){
        return orderService.create(order);}

    @RequestMapping(value = "/order/{id}",method = RequestMethod.PUT)
    public @ResponseBody Order update(@PathVariable("id")String id, @RequestBody Order order,BindingResult bindingResult) {
        return orderService.update(order);
    }
    @RequestMapping(value = "/order/{id}",method = RequestMethod.DELETE)
    public Order delete (@PathVariable("id")String id){
        return orderService.delete(orderService.getOrder(id));}

    @RequestMapping(value = "order/tranfer",method = RequestMethod.POST)
    @ResponseBody
    public Order addImage(HttpServletRequest request,
                            HttpServletResponse response, @RequestParam("orderid")String orderid){
        MultipartHttpServletRequest mRequest;
        Order order = orderService.getOrder(orderid);
        try{
            mRequest = (MultipartHttpServletRequest)request;
            Iterator<String> itr= mRequest.getFileNames();
            while(itr.hasNext()){
                MultipartFile multipartFile = mRequest.getFile(itr.next());
                Image image = new Image();
                image.setFileName(multipartFile.getOriginalFilename());
                image.setContentType(multipartFile.getContentType());
                image.setContent(multipartFile.getBytes());;
                image.setCreated(Calendar.getInstance().getTime());
                orderService.addImage(order,image);
            }
        }catch (Exception e){
            e.printStackTrace();
        }


        return order;
    }
}
