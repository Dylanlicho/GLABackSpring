package fr.univlorraine.apde.dao;

import fr.univlorraine.apde.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

/**
 *
 * @author DylanLICHO
 */
public interface IUserRepository extends CrudRepository<User, Integer> {
    Optional<User> findByLogin(String login);
    Boolean existsByLogin(String login);
}
