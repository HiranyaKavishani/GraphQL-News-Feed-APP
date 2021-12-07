package newsfeed.spring.graphql.service;

import com.rometools.rome.feed.synd.SyndEntry;
import com.rometools.rome.feed.synd.SyndFeed;
import com.rometools.rome.io.FeedException;
import com.rometools.rome.io.SyndFeedInput;
import com.rometools.rome.io.XmlReader;
import newsfeed.spring.graphql.dto.NewsFeed;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import newsfeed.spring.graphql.repository.NewsRepository;

import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

/*
 * a sample scheduled task. Spring scheduled is not cluster-friendly. If you are running a cluster
 *  you have to enable scheduling in one app instance and disable it in all others. (see application.yml)
 */
@Service
@EnableAsync
@Component
public class NewsPullerScheduledTask {

	private static final Logger log = LoggerFactory.getLogger(NewsPullerScheduledTask.class);
	String url = "http://feeds.nos.nl/nosjournaal?format=xml";

	// set this to false to disable this job; set it it true by
	@Value("${scheduledJob.enabled:false}")
	private boolean scheduledJobEnabled;

	@Autowired
	private NewsRepository feedRepository;

	private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
	private final AtomicInteger count = new AtomicInteger(0);

	@Scheduled(fixedRate = 30000)  // every 5 minutes
	public void pullNewsData() {
		this.count.incrementAndGet();
		if (!scheduledJobEnabled) {
			return;
		}
		String execution = UUID.randomUUID().toString();
		log.info("execution: " + execution);
		try {
			SyndFeed syndFeed = new SyndFeedInput().build(new XmlReader(new URL(url)));
			if (syndFeed != null) {
				List<SyndEntry> lastTenEntries = syndFeed.getEntries();
				// pick last 10 news
				lastTenEntries = lastTenEntries.subList(lastTenEntries.size()-10, lastTenEntries.size());
				for (SyndEntry entry : lastTenEntries) {
					NewsFeed feed = new NewsFeed();
					feed.setExecution(execution);
					feed.setTitle(entry.getTitle());
					feed.setLink(entry.getLink());
					feed.setPublicationDate(entry.getPublishedDate());
					feed.setDescription(entry.getDescription().getValue());
					feedRepository.save(feed);
				}
			}
		} catch (FeedException e) {
			log.error("There was an error parsing the RSS feed", e);
		} catch (IOException e) {
			log.error("There was an error getting the data from the URL", e);
		}

	}

	public int getInvocationCount() {
		return this.count.get();
	}
}
