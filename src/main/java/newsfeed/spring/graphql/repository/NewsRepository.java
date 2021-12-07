package newsfeed.spring.graphql.repository;

import newsfeed.spring.graphql.dto.NewsFeed;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NewsRepository extends JpaRepository<NewsFeed, Integer> {
}
