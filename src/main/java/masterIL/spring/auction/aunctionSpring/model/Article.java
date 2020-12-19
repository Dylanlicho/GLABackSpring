package masterIL.spring.auction.aunctionSpring.model;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import javax.persistence.*;
import java.util.Date;

@Service
@Scope("prototype")
@Entity
@Table(name = "Articles")
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    // Name of the article
    @Column(name = "name")
    private String name;
    // Id of the seller
    @Column(name = "seller")
    private int seller;
    // Starting price of the article
    @Column(name = "startprice")
    private double startPrice;
    // Price of the object outside aunction
    @Column(name = "price")
    private double price;
    // Starting date of aunction for this article
    @Column(name = "startdate")
    private Date startDate;
    // Ending date of aunction for this article
    @Column(name = "enddate")
    private Date endDate;
    // Weight of the article
    @Column(name = "weight")
    private double weight;

    public Article() {
    }

    public Article(int id, String name, int seller, double startPrice, double price, Date startDate, Date endDate, double weight) {
        this.id = id;
        this.name = name;
        this.seller = seller;
        this.startPrice = startPrice;
        this.price = price;
        this.startDate = startDate;
        this.endDate = endDate;
        this.weight = weight;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSeller() {
        return seller;
    }

    public void setSeller(int seller) {
        this.seller = seller;
    }

    public double getStartPrice() {
        return startPrice;
    }

    public void setStartPrice(double startPrice) {
        this.startPrice = startPrice;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

}
