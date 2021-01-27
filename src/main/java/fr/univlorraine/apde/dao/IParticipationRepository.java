package fr.univlorraine.apde.dao;

import fr.univlorraine.apde.model.Article;
import fr.univlorraine.apde.model.participationEntity.Participation;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

/**
 *
 * @author DylanLICHO
 */
public interface IParticipationRepository extends CrudRepository<Participation, Integer> {
    @Query(value = "SELECT * FROM participation WHERE idArticle = ?1 ORDER BY price DESC LIMIT 1", nativeQuery = true)
    Optional<Participation> findBestBidder(Integer idArticle);

}
