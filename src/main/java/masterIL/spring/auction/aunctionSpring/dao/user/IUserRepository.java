package masterIL.spring.auction.aunctionSpring.dao.user;

import masterIL.spring.auction.aunctionSpring.model.Users;
import org.springframework.data.repository.CrudRepository;

public interface IUserRepository extends CrudRepository<Users, Integer> {
}
