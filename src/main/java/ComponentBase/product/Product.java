package ComponentBase.product;

import ComponentBase.image.Image;
import ComponentBase.review.Review;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by panit on 5/7/2016.
 */
@Entity
@Document
public class Product {
    @Id
    private String id;
    @Indexed(unique = true)
    private String name;
    private String description;
    private double price;
    private double priceRetailer;
    private double priceWholesaler;
    private String category;
    private String type;
    private Set<Image> images= new HashSet<>();
    private Set<Review> reviews = new HashSet<>();
    public Product(){}
    public Product(String name, String description, double price,
                   double priceRetailer,double priceWholesaler, String category,
                   String type ) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.priceRetailer = priceRetailer;
        this.priceWholesaler = priceWholesaler;
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

    public double getPriceRetailer() {
        return priceRetailer;
    }

    public void setPriceRetailer(double priceRetailer) {
        this.priceRetailer = priceRetailer;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Set<Image> getImages() {
        return images;
    }

    public void setImages(Set<Image> images) {
        this.images = images;
    }

    public Set<Review> getReviews() {
        return reviews;
    }

    public void setReviews(Set<Review> reviews) {
        this.reviews = reviews;
    }

    public double getPriceWholesaler() {
        return priceWholesaler;
    }

    public void setPriceWholesaler(double priceWholesaler) {
        this.priceWholesaler = priceWholesaler;
    }
}
