package fr.univlorraine.apde.model.participationEntity;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import javax.persistence.*;

/**
 *
 * @author DylanLICHO
 */
@Scope("prototype")
@Entity
@Table(name="Participation")
@IdClass(PrimaryKeyParticipation.class)
public class Participation {

    // Id of the owner
    @Id
    @Column(name = "iduser")
    private int idUser;
    // Id of the article
    @Id
    @Column(name = "idarticle")
    private int idArticle;
    // Price of the participation
    @Column(name = "price")
    private double price;

    public Participation() {
    }

    public Participation(int idUser, int idArticle, double price) {
        this.idUser = idUser;
        this.idArticle = idArticle;
        this.price = price;
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
