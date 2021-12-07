package newsfeed.spring.graphql;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@ComponentScan(basePackages = "newsfeed.spring.graphql")
public class SampleSpringBootGraphQLKickstartApp {

	public static void main(String[] args) {
		SpringApplication.run(SampleSpringBootGraphQLKickstartApp.class);
	}
}
