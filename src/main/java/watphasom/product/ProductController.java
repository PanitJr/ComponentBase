package watphasom.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import watphasom.content.Content;
import watphasom.image.Image;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;

/**
 * Created by panit on 5/16/2016.
 */
@CrossOrigin
@RestController
public class ProductController {
    @Autowired
    ProductService productService;

    @RequestMapping(value = "/product",method = RequestMethod.GET)
    public List<Product> list (){return productService.getProducts();}

    @RequestMapping(value = "/product/{id}",method = RequestMethod.GET)
    public Product getProduct(@PathVariable("id")String id){return productService.getProduct(id);}

    @RequestMapping(value = "/product",method = RequestMethod.POST)
    public Product create(@RequestBody Product product){
        return productService.create(product);}

    @RequestMapping(value = "/product/{id}",method = RequestMethod.PUT)
    public Product update(@PathVariable("id")String id,@RequestBody Product product){
        return productService.update(id,product);
    }

    @RequestMapping(value = "/product/{id}",method = RequestMethod.DELETE)
    public Product delete(@PathVariable("id")String id){
        return productService.delete(id);
    }

    @RequestMapping(value = "/productImage/add",method = RequestMethod.POST)
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
                image.setContent(multipartFile.getBytes());
                image.setCreated(Calendar.getInstance().getTime());
                productService.addImage(product,image);
            }
        }catch (Exception e){
            e.printStackTrace();
        }


        return product;
    }
    @RequestMapping(value = "/product/search/{name}",method = RequestMethod.GET)
    public List<Product> getProductByName(@PathVariable("name")String name){return productService.findByNameContaining(name);}

    @RequestMapping(value = "/product/search/{category}",method = RequestMethod.GET)
    public List<Product> getProductByCategory(@PathVariable("category")String category){return productService.findByCategory(category);}

    @RequestMapping(value = "/product/search/{type}",method = RequestMethod.GET)
    public List<Product> getProductByType(@PathVariable("type")String type){return productService.findByType(type);}

    @RequestMapping(value = "/product/addreview/{id}",method = RequestMethod.PUT)
    public Product addReview (@PathVariable("id")String id , @RequestBody Content content){
        return productService.addReview(id,content);}

}
