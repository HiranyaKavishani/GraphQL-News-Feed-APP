package newsfeed.spring.graphql.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

@Configuration
@EnableScheduling
@ComponentScan("samples.spring.graphql")
public class ScheduledConfig {
}
