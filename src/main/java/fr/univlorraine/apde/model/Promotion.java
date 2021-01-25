package fr.univlorraine.apde.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import javax.persistence.*;

/**
 *
 * @author DylanLICHO
 */
@Service
@Scope("prototype")
@Entity
@Table(name = "Promotions")
public class Promotion {

    @Id
    @Column(name="idarticle")
    private int idArticle;

    @Column(name="reduction")
    private int reduction;

    @OneToOne
    @JoinColumn(name= "idarticle", referencedColumnName="id", updatable = false, insertable = false)
    Article article;

    public Promotion(){}

    public Promotion(int idArticle, int reduction) {
        this.idArticle = idArticle;
        this.reduction = reduction;
    }

    public int getIdArticle() {
        return idArticle;
    }

    public void setIdArticle(int idArticle) {
        this.idArticle = idArticle;
    }

    public int getReduction() {
        return reduction;
    }

    public void setReduction(int reduction) {
        this.reduction = reduction;
    }

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }
}
