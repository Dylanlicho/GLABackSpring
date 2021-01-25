package fr.univlorraine.apde.dao;

import fr.univlorraine.apde.model.Promotion;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

/**
 *
 * @author DylanLICHO
 */
public interface IPromotionRepository extends CrudRepository<Promotion, Integer> {

}
