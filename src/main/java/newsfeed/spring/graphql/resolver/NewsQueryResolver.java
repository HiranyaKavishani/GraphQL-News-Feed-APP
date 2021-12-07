package newsfeed.spring.graphql.resolver;

import graphql.kickstart.tools.GraphQLQueryResolver;
import newsfeed.spring.graphql.dto.NewsFeed;
import newsfeed.spring.graphql.filter.FilterField;
import newsfeed.spring.graphql.repository.NewsRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

@Component
public class NewsQueryResolver implements GraphQLQueryResolver {

	private NewsRepository repository;

	@Value("${countOfNews.count}")
	private String news;

	NewsQueryResolver(NewsRepository repository) {
		this.repository = repository;
	}

	public Iterable<NewsFeed> newsList() {
		return repository.findAll();
	}

	public NewsFeed news(int id) {
		return repository.findById(id).get();
	}

	private Specification<NewsFeed> byTitle(FilterField filterField) {
		return (Specification<NewsFeed>) (root, query, builder) -> filterField.generateCriteria(builder, root.get("title"));
	}
}
