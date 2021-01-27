package fr.univlorraine.apde.model.ofCategoryEntity;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import javax.persistence.*;

/**
 *
 * @author DylanLICHO
 */
@Scope("prototype")
@Entity
@Table(name="Of_category")
@IdClass(PrimaryKeyOfCategory.class)
public class OfCategory {

    // Id of the article concerned
    @Id
    @Column(name = "idarticle")
    private int idArticle;
    // Id of the category of the article
    @Id
    @Column(name = "idcategory")
    private int idCategory;

    public OfCategory() {
    }

    public OfCategory(int idArticle, int idCategory) {
        this.idArticle = idArticle;
        this.idCategory = idCategory;
    }

    public int getIdArticle() {
        return idArticle;
    }

    public void setIdArticle(int idArticle) {
        this.idArticle = idArticle;
    }

    public int getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(int idCategory) {
        this.idCategory = idCategory;
    }
}
