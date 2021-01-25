package fr.univlorraine.apde.controller;

import fr.univlorraine.apde.dao.IArticleRepository;
import fr.univlorraine.apde.dao.IPromotionRepository;
import fr.univlorraine.apde.model.Promotion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

/**
 *
 * @author DylanLICHO
 */
@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class PromotionController {

    @Autowired
    private IPromotionRepository dao;

    @GetMapping(value = "promotions")
    public Iterable<Promotion> findAll(){
        return dao.findAll();
    }

    @GetMapping(value = "promotion/{id}")
    public Optional<Promotion> getPromotionById(@PathVariable Integer id){
        return dao.findById(id);
    }

    @GetMapping(value = "existPromotion/{id}")
    public boolean existPromotionById(@PathVariable Integer id){return dao.existsById(id);}

    @GetMapping(value = "countPromotions")
    public long count(){return dao.count();}

    @PostMapping(value = "addPromotion")
    public Promotion addPromotion(@RequestBody Promotion promotion){
        return dao.save(promotion);
    }

    @DeleteMapping(value = "deletePromotionByPromotion")
    public void deletePromotionByPromotion(@RequestBody Promotion promotion){ dao.delete(promotion);}

    @DeleteMapping(value = "deletePromotionById/{id}")
    public void deletePromotionById(@PathVariable Integer id){ dao.deleteById(id);}

}
