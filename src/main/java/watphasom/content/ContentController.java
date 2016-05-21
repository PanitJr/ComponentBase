package watphasom.content;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import watphasom.product.Product;

import java.util.List;

/**
 * Created by panit on 5/19/2016.
 */
@CrossOrigin
@RestController
public class ContentController {
    @Autowired
    ContentService contentService;

    @RequestMapping(value = "/content",method = RequestMethod.GET)
    public List<Content> list (){return contentService.list();}

    @RequestMapping(value = "/content/{id}",method = RequestMethod.GET)
    public Content getContent(@PathVariable("id")String id){return contentService.getOne(id);}

    @RequestMapping(value = "/content",method = RequestMethod.POST)
    public @ResponseBody Content create(@RequestBody Content content){
        return contentService.create(content);}

    @RequestMapping(value = "/content/{id}",method = RequestMethod.PUT)
    public @ResponseBody Content update(@PathVariable("id")String id,@RequestBody Content content){
        return contentService.update(content);
    }

    @RequestMapping(value = "/content/{id}",method = RequestMethod.DELETE)
    public @ResponseBody Content delete(@PathVariable("id")String id){
        return contentService.delete(id);
    }
}
