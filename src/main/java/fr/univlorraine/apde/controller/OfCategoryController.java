package fr.univlorraine.apde.controller;

import fr.univlorraine.apde.dao.IOfCategoryRepository;
import fr.univlorraine.apde.model.ofCategoryEntity.OfCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class OfCategoryController {

    @Autowired
    private IOfCategoryRepository dao;

    @GetMapping(value = "ofCategories")
    public Iterable<OfCategory> findAll(){
        return dao.findAll();
    }

    @GetMapping(value = "ofCategory/{id}")
    public Optional<OfCategory> getOfCategoryById(@PathVariable Integer id){
        return dao.findById(id);
    }

    @GetMapping(value = "existOfCategory/{id}")
    public boolean existOfCategoryById(@PathVariable Integer id){return dao.existsById(id);}

    @GetMapping(value = "countOfCategories")
    public long count(){return dao.count();}

    @PostMapping(value = "addOfCategory")
    public void addOfCategory(@RequestBody OfCategory ofcategory){
        dao.save(ofcategory);
    }

    @DeleteMapping(value = "deleteOfCategoryByOfCategory")
    public void deleteOfCategoryByOfCategory(@RequestBody OfCategory ofcategory){ dao.delete(ofcategory);}

    @DeleteMapping(value = "deleteOfCategoryById/{id}")
    public void deleteOfCategoryById(@PathVariable Integer id){ dao.deleteById(id);}


}
