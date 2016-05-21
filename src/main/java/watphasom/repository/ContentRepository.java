package watphasom.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import watphasom.content.Content;

/**
 * Created by panit on 5/19/2016.
 */
public interface ContentRepository extends MongoRepository<Content,String> {
}
