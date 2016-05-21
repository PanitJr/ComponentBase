package watphasom.content;

import java.util.List;

/**
 * Created by panit on 5/19/2016.
 */

public interface ContentService {
    List<Content> list();
    Content getOne(String id);
    Content create(Content content);
    Content update(Content content);
    Content delete(String id);
}
