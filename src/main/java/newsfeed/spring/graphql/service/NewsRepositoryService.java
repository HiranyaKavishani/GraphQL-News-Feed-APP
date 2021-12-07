package newsfeed.spring.graphql.service;

import newsfeed.spring.graphql.dto.News;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Customized repository for the Topic entity
 * 
 * @author Hiranya Abeyrathne <hiranyakavi@gmail.com>
 *
 */
@Repository
public class NewsRepositoryService {

	@Value("${countOfNews.count}")
	private String news;
	
	@PersistenceContext
	private EntityManager entityManager;

	public List<News> getNewsFeeds() throws ParseException {

		List<Object[]> results = entityManager.createQuery(
				"SELECT id, title, description, link, publicationDate FROM NewsFeed", Object[].class).
				setMaxResults(Integer.valueOf(news)).getResultList();
		List<News> newsFeedList = new ArrayList<>();
		for (Object[] result : results) {
			Date date =new SimpleDateFormat("dd/MM/yyyy").parse(result[4].toString());
			News news = new News(result[1].toString(), result[2].toString(), result[3].toString(), date);
			newsFeedList.add(news);
		}
		return newsFeedList;
	}
}
