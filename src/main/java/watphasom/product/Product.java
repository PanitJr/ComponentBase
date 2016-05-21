package watphasom.product;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import watphasom.content.Content;
import watphasom.image.Image;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by panit on 5/16/2016.
 */
@Document
public class Product {
    @Id
    private String id;
    @Indexed(unique = true)
    private String name;
    private String description;
    private double price;
    private double wholesalePrice;
    private double retailPrice;
    private Set<Image> images = new HashSet<>();
    @DBRef
    private Set<Content> reviews = new HashSet<Content>();
    private String category;
    private String type;

    public Product() {
    }

    public Product(String name, String description, double price, double wholesalePrice,
                   double retailPrice, Image image, String category, String type) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.wholesalePrice = wholesalePrice;
        this.retailPrice = retailPrice;
        this.images.add(image);
        this.category = category;
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getWholesalePrice() {
        return wholesalePrice;
    }

    public void setWholesalePrice(double wholesalePrice) {
        this.wholesalePrice = wholesalePrice;
    }

    public double getRetailPrice() {
        return retailPrice;
    }

    public void setRetailPrice(double retailPrice) {
        this.retailPrice = retailPrice;
    }

    public Set<Image> getImages() {
        return images;
    }

    public void setImages(Set<Image> images) {
        this.images = images;
    }

    public Set<Content> getReviews() {
        return reviews;
    }

    public void setReviews(Set<Content> reviews) {
        this.reviews = reviews;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
