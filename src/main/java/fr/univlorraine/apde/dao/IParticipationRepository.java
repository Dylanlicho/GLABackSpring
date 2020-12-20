package fr.univlorraine.apde.dao;

import fr.univlorraine.apde.model.participationEntity.Participation;
import org.springframework.data.repository.CrudRepository;

public interface IParticipationRepository extends CrudRepository<Participation, Integer> {
}
