package fr.univlorraine.apde.controller;

import fr.univlorraine.apde.dao.IArticleRepository;
import fr.univlorraine.apde.model.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

/**
 *
 * @author DylanLICHO
 */
@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class ArticleController {

    @Autowired
    private IArticleRepository dao;

    @GetMapping(value = "articles")
    public Iterable<Article> findAll(){
        return dao.findAll();
    }

    @GetMapping(value = "article/{id}")
    public Optional<Article> getArticleById(@PathVariable Integer id){
        return dao.findById(id);
    }

    @GetMapping(value = "article/seller/{seller}")
    public Optional<Article[]> getArticleBySeller(@PathVariable Integer seller){
        return dao.findBySeller(seller);
    }

    @GetMapping(value = "existArticle/{id}")
    public boolean existArticleById(@PathVariable Integer id){return dao.existsById(id);}

    @GetMapping(value = "countArticles")
    public long count(){return dao.count();}

    @PostMapping(value = "addArticle")
    public Article addArticle(@RequestBody Article article){
        return dao.save(article);
    }

    @DeleteMapping(value = "deleteArticleByArticle")
    public void deleteArticleByArticle(@RequestBody Article article){ dao.delete(article);}

    @DeleteMapping(value = "deleteArticleById/{id}")
    public void deleteArticleById(@PathVariable Integer id){ dao.deleteById(id);}


}
