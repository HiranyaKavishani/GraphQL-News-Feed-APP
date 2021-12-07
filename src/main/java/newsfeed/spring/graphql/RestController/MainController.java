package newsfeed.spring.graphql.RestController;

import newsfeed.spring.graphql.dto.News;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import newsfeed.spring.graphql.service.NewsRepositoryService;

import java.util.List;

/**
 * Main Rest Controller, containing get endpoints available
 * 
 * @author Hiranya Abeyrathne <hiranyakavi@gmail.com>
 *
 */
@RestController
public class MainController {

	final static Logger logger = LoggerFactory.getLogger(MainController.class);

	@Autowired
	private NewsRepositoryService newsfeedService;

	@RequestMapping(value = "/newsfeeds/", method = RequestMethod.GET)
	public ResponseEntity<List<News>> newsFeeds() {
		try {
			List<News> result = newsfeedService.getNewsFeeds();
			if (result.size() == 0) {
				return new ResponseEntity<List<News>>(HttpStatus.NOT_FOUND);
			}
			return new ResponseEntity<List<News>>(result, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("Unexpected error", e);
			return new ResponseEntity<List<News>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
