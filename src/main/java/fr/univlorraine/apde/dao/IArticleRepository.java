package fr.univlorraine.apde.dao;

import fr.univlorraine.apde.model.Article;
import fr.univlorraine.apde.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

/**
 *
 * @author DylanLICHO
 */
public interface IArticleRepository extends CrudRepository<Article, Integer> {
    Optional<Article[]> findBySeller(Integer seller);

    @Query(value = "select * from articles inner join of_category on of_category.idCategory = ?1 where articles.id = of_category.idArticle", nativeQuery = true)
    Optional<Article[]> findByCategoryId(Integer categoryId);

    Optional<Article[]> findByName(String name);
}
