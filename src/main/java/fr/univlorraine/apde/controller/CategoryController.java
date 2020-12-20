package fr.univlorraine.apde.controller;

import fr.univlorraine.apde.dao.ICategoryRepository;
import fr.univlorraine.apde.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class CategoryController {

    @Autowired
    private ICategoryRepository dao;

    @GetMapping(value = "categories")
    public Iterable<Category> findAll(){
        return dao.findAll();
    }

    @GetMapping(value = "category/{id}")
    public Optional<Category> getCategoryById(@PathVariable Integer id){
        return dao.findById(id);
    }

    @GetMapping(value = "existCategory/{id}")
    public boolean existCategoryById(@PathVariable Integer id){return dao.existsById(id);}

    @GetMapping(value = "countCategories")
    public long count(){return dao.count();}

    @PostMapping(value = "addCategory")
    public void addCategory(@RequestBody Category category){
        dao.save(category);
    }

    @DeleteMapping(value = "deleteCategoryByCategory")
    public void deleteCategoryByCategory(@RequestBody Category category){ dao.delete(category);}

    @DeleteMapping(value = "deleteCategoryById/{id}")
    public void deleteCategoryById(@PathVariable Integer id){ dao.deleteById(id);}


}
