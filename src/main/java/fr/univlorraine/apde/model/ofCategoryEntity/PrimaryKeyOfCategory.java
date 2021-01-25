package fr.univlorraine.apde.model.ofCategoryEntity;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author DylanLICHO
 */
public class PrimaryKeyOfCategory implements Serializable {

    // Id of the article
    private int idArticle;

    // Id of the category of the article
    private int idCategory;

    public PrimaryKeyOfCategory() {
    }

    public PrimaryKeyOfCategory(int idArticle, int idCategory) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PrimaryKeyOfCategory that = (PrimaryKeyOfCategory) o;
        return getIdArticle() == that.getIdArticle() &&
                getIdCategory() == that.getIdCategory();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIdArticle(), getIdCategory());
    }
}
