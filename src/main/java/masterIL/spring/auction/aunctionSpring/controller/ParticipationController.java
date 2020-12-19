package masterIL.spring.auction.aunctionSpring.controller;

import masterIL.spring.auction.aunctionSpring.dao.IArticleRepository;
import masterIL.spring.auction.aunctionSpring.dao.IParticipationRepository;
import masterIL.spring.auction.aunctionSpring.model.Article;
import masterIL.spring.auction.aunctionSpring.model.participationEntity.Participation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class ParticipationController {

    @Autowired
    private IParticipationRepository dao;

    @GetMapping(value = "participations")
    public Iterable<Participation> findAll(){
        return dao.findAll();
    }

    @GetMapping(value = "participation/{id}")
    public Optional<Participation> getParticipationById(@PathVariable Integer id){
        return dao.findById(id);
    }

    @GetMapping(value = "existParticipation/{id}")
    public boolean existParticipationById(@PathVariable Integer id){return dao.existsById(id);}

    @GetMapping(value = "countParticipation")
    public long count(){return dao.count();}

    @PostMapping(value = "addParticipation")
    public void addParticipation(@RequestBody Participation participation){
        dao.save(participation);
    }

    @DeleteMapping(value = "deleteParticipationByParticipation")
    public void deleteParticipationByParticipation(@RequestBody Participation participation){ dao.delete(participation);}

    @DeleteMapping(value = "deleteParticipationById/{id}")
    public void deleteParticipationById(@PathVariable Integer id){ dao.deleteById(id);}


}
