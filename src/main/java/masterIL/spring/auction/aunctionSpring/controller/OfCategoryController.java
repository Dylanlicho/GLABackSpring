package masterIL.spring.auction.aunctionSpring.controller;

import masterIL.spring.auction.aunctionSpring.dao.ICategoryRepository;
import masterIL.spring.auction.aunctionSpring.dao.IOfCategoryRepository;
import masterIL.spring.auction.aunctionSpring.model.Category;
import masterIL.spring.auction.aunctionSpring.model.ofCategoryEntity.OfCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

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

    @GetMapping(value = "countOfCategory")
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
