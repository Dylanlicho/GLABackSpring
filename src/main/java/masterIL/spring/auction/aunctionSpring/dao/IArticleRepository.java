package masterIL.spring.auction.aunctionSpring.dao;

import masterIL.spring.auction.aunctionSpring.model.Article;
import org.springframework.data.repository.CrudRepository;

public interface IArticleRepository extends CrudRepository<Article, Integer> {
}
