package fr.univlorraine.apde.dao;

import fr.univlorraine.apde.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface IUserRepository extends CrudRepository<User, Integer> {
    Optional<User> findByLogin(String login);
}
