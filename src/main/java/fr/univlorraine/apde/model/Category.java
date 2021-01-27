package fr.univlorraine.apde.model;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import javax.persistence.*;

/**
 *
 * @author DylanLICHO
 */
@Scope("prototype")
@Entity
@Table(name="Categories")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    // Name of the category, need to be unique
    @Column(name = "name")
    private String name;

    public Category() {
    }

    public Category(int id, String name) {
        this.id = id;
        this.name = name;
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
}
