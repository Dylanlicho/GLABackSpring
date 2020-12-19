package masterIL.spring.auction.aunctionSpring.dao;

import masterIL.spring.auction.aunctionSpring.model.User;
import org.springframework.data.repository.CrudRepository;

public interface IUserRepository extends CrudRepository<User, Integer> {
}
