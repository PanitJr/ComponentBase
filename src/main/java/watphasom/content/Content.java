package watphasom.content;

import org.springframework.data.mongodb.core.mapping.DBRef;
import watphasom.image.Image;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Entity;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by panit on 5/18/2016.
 */
@Document
@Entity
public class Content {
    @Id
    private String id;
    private String title;
    private String description;
    private Set<Image> images =new HashSet<>();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<Image> getImages() {
        return images;
    }

    public void setImages(Set<Image> images) {
        this.images = images;
    }
}
