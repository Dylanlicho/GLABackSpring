package fr.univlorraine.apde.securityJWT.service;

import fr.univlorraine.apde.model.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Objects;

/**
 *
 * @author DylanLICHO
 */
// user details
public class UserDetailsImpl implements UserDetails {

    private int id;
    private String firstName;
    private String lastName;
    private String login;
    private String password;
    private String address;

    public UserDetailsImpl(int id, String firstname, String lastname, String login, String address, String password) {
        this.id = id;
        this.firstName = firstname;
        this.lastName = lastname;
        this.login = login;
        this.address = address;
        this.password = password;
    }

    // Giving an User build a UserDetailsImpl
    public static UserDetailsImpl build(User user) {
        return new UserDetailsImpl(
                user.getId(),
                user.getFirstname(),
                user.getLastname(),
                user.getLogin(),
                user.getAddress(),
                user.getPassword());
    }

    // Haven't role so we don't care
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    public int getId(){
        return id;
    }

    public String getFirstName(){
        return firstName;
    }

    public String getLastName(){
        return lastName;
    }

    public String getAddress(){
        return address;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return login;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserDetailsImpl that = (UserDetailsImpl) o;
        return getId() == that.getId() &&
                Objects.equals(login, that.login) &&
                Objects.equals(getPassword(), that.getPassword());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), login, getPassword());
    }

    @Override
    public String toString() {
        return "UserDetailsImpl{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
