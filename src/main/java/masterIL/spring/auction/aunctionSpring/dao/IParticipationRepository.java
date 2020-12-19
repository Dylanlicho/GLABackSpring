package masterIL.spring.auction.aunctionSpring.dao;

import masterIL.spring.auction.aunctionSpring.model.participationEntity.Participation;
import org.springframework.data.repository.CrudRepository;

public interface IParticipationRepository extends CrudRepository<Participation, Integer> {
}
