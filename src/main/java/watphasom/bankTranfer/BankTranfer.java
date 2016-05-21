package watphasom.bankTranfer;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import watphasom.image.Image;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by panit on 5/19/2016.
 */
@Document
public class BankTranfer {
    @Id
    private String id;
    @CreatedDate
    private Date create;
    private Set<Image> images = new HashSet<>();

    public BankTranfer() {
    }

    public BankTranfer(Image image) {
        this.images.add(image);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getCreate() {
        return create;
    }

    public void setCreate(Date create) {
        this.create = create;
    }

    public Set<Image> getImages() {
        return images;
    }

    public void setImages(Set<Image> images) {
        this.images = images;
    }
}
