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
@Table(name="Users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;
    // Firstname of the user
    @Column(name = "firstname")
    private String firstname;
    // Lastname of the user
    @Column(name = "lastname")
    private String lastname;
    // Login of the user
    @Column(name = "login")
    private String login;
    // Address of the user
    @Column(name = "address")
    private String address;
    // Password of the user
    @Column(name = "password")
    private String password;

    public User(int id, String firstname, String lastname, String login, String address, String password) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.login = login;
        this.address = address;
        this.password = password;
    }

    public User(String firstname, String lastname, String login, String address, String password) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.login = login;
        this.address = address;
        this.password = password;
    }

    public User() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Users{" +
                "id=" + id +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", login='" + login + '\'' +
                ", address='" + address + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
