package fr.univlorraine.apde.dao;

import fr.univlorraine.apde.model.Article;
import org.springframework.data.repository.CrudRepository;

public interface IArticleRepository extends CrudRepository<Article, Integer> {
}
