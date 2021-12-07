package newsfeed.spring.scheduledTask;

import newsfeed.spring.graphql.config.ScheduledConfig;
import newsfeed.spring.graphql.repository.NewsRepository;
import newsfeed.spring.graphql.service.NewsPullerScheduledTask;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import static org.assertj.core.api.Assertions.assertThat;

@SpringJUnitConfig(ScheduledConfig.class)
public class NewsPullerScheduledTaskIntegrationTest {

    @SpyBean private NewsPullerScheduledTask counter;

    @MockBean private NewsRepository feedRepository;

    @Test
    public void givenSleepBy100ms_whenGetInvocationCount_thenIsGreaterThanZero() throws InterruptedException {
        Thread.sleep(100L);
        assertThat(counter.getInvocationCount()).isGreaterThan(0);
    }

}

