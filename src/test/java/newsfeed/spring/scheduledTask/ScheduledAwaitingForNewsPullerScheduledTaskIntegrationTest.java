package newsfeed.spring.scheduledTask;

import newsfeed.spring.graphql.repository.NewsRepository;
import org.awaitility.Duration;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import newsfeed.spring.graphql.config.ScheduledConfig;
import newsfeed.spring.graphql.service.NewsPullerScheduledTask;

import static org.awaitility.Awaitility.await;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.atLeast;

@SpringJUnitConfig(ScheduledConfig.class)
class ScheduledAwaitingForNewsPullerScheduledTaskIntegrationTest {

    @SpyBean private NewsPullerScheduledTask counter;

    @MockBean private NewsRepository feedRepository;

    @Test
    public void whenWaitTenMinutes_thenScheduledIsCalledAtLeastTwoTimes() {
        await().atMost(Duration.FIVE_MINUTES)
                .untilAsserted(() -> verify(counter, atLeast(1)).pullNewsData());
    }
}
