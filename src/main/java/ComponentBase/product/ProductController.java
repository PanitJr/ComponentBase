package ComponentBase.product;

import ComponentBase.image.Image;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
@Controller
@RequestMapping("/products")
public class ProductController {
    @Autowired ProductService productService;

    //CRUD

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public Product getProduct(@PathVariable("id")String id){
        return productService.getProduct(id);
    }
    @RequestMapping(value = "/",method = RequestMethod.GET)
    public List<Product> getProduct(){return productService.getProducts();}

    @RequestMapping(value = "/search/",method = RequestMethod.GET)
    public  List<Product> getListByName(@RequestParam("name")String name){
        return productService.findByName(name);
    }
    @RequestMapping(value = "",method = RequestMethod.POST)
    public @ResponseBody Product add(@RequestBody Product product, BindingResult bindingResult){
        return productService.create(product);
    }
    @RequestMapping(value = "/{id}",method = RequestMethod.PUT)
    public  Product edit(@PathVariable("id") String id,@RequestBody Product product, BindingResult bindingResult){
        return productService.edit(product);
    }
    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    public  Product edit(@PathVariable("id") String id){
        return productService.delete(id);
    }

    //Service
    @RequestMapping(value = "/addimage",method = RequestMethod.POST)
    @ResponseBody
    public Product addImage(HttpServletRequest request,
                            HttpServletResponse response, @RequestParam("productid")String productId){
        MultipartHttpServletRequest mRequest;
        Product product = productService.getProduct(productId);
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
                productService.addImage(product,image);
            }
        }catch (Exception e){
            e.printStackTrace();
        }


        return product;
    }


}
