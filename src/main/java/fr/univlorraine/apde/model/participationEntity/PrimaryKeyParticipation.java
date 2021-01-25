package fr.univlorraine.apde.model.participationEntity;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author DylanLICHO
 */
public class PrimaryKeyParticipation implements Serializable {

    // Id of the user who participate to the aunction
    private int idUser;
    // Id of the article sold
    private int idArticle;

    public PrimaryKeyParticipation() {
    }

    public PrimaryKeyParticipation(int idUser, int idArticle) {
        this.idUser = idUser;
        this.idArticle = idArticle;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public int getIdArticle() {
        return idArticle;
    }

    public void setIdArticle(int idArticle) {
        this.idArticle = idArticle;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PrimaryKeyParticipation that = (PrimaryKeyParticipation) o;
        return getIdUser() == that.getIdUser() &&
                getIdArticle() == that.getIdArticle();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIdUser(), getIdArticle());
    }
}
