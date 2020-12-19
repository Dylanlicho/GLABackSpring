package masterIL.spring.auction.aunctionSpring.dao;

import masterIL.spring.auction.aunctionSpring.model.Category;
import org.springframework.data.repository.CrudRepository;

public interface ICategoryRepository extends CrudRepository<Category, Integer> {
}
