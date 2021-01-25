package fr.univlorraine.apde.controller;

import fr.univlorraine.apde.dao.IParticipationRepository;
import fr.univlorraine.apde.model.participationEntity.Participation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

/**
 *
 * @author DylanLICHO
 */
@CrossOrigin(origins = "http://localhost:4200")
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

    @GetMapping(value = "participation/best/{idArticle}")
    public Optional<Participation> getBestParticipationByIdArticle(@PathVariable Integer idArticle){
        return dao.findBestBidder(idArticle);
    }

    @GetMapping(value = "existParticipation/{id}")
    public boolean existParticipationById(@PathVariable Integer id){return dao.existsById(id);}

    @GetMapping(value = "countParticipations")
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
