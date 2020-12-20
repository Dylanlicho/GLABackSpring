package fr.univlorraine.apde.dao;

import fr.univlorraine.apde.model.User;
import org.springframework.data.repository.CrudRepository;

public interface IUserRepository extends CrudRepository<User, Integer> {
}
