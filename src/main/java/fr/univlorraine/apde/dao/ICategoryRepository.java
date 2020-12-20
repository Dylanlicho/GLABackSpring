package fr.univlorraine.apde.dao;

import fr.univlorraine.apde.model.Category;
import org.springframework.data.repository.CrudRepository;

public interface ICategoryRepository extends CrudRepository<Category, Integer> {
}
