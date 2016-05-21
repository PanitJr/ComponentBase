package watphasom.content;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by panit on 5/19/2016.
 */
@Service
public class ContentServiceImpl implements ContentService{
    @Autowired
    ContentDao contentDao;

    @Override
    public List<Content> list() {
        return contentDao.list();
    }

    @Override
    public Content getOne(String id) {
        return contentDao.getOne(id);
    }

    @Override
    public Content create(Content content) {
        return contentDao.create(content);
    }

    @Override
    public Content update(Content content) {
        return contentDao.update(content);
    }

    @Override
    public Content delete(String id) {
        return contentDao.delete(contentDao.getOne(id));
    }
}
