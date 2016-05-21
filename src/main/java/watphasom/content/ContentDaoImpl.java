package watphasom.content;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import watphasom.repository.ContentRepository;

import java.util.List;

/**
 * Created by panit on 5/19/2016.
 */
@Repository
public class ContentDaoImpl implements ContentDao {

    @Autowired
    ContentRepository contentRepository;
    @Override
    public List<Content> list() {
        return contentRepository.findAll();
    }

    @Override
    public Content getOne(String id) {
        return contentRepository.findOne(id);
    }

    @Override
    public Content create(Content content) {
        return contentRepository.save(content);
    }

    @Override
    public Content update(Content content) {
        return contentRepository.save(content);
    }

    @Override
    public Content delete(Content content) {
        contentRepository.delete(content);
        content.setId(null);
        return content;
    }
}
