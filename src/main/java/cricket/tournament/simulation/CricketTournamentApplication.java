package cricket.tournament.simulation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan({"cricket.tournament.simulation.*"})
public class CricketTournamentApplication extends SpringBootServletInitializer {

    public static final Logger LOGGER = LoggerFactory.getLogger(CricketTournamentApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(CricketTournamentApplication.class, args);

        LOGGER.info("Started CricketTournamentApplication successfully");
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(CricketTournamentApplication.class);
    }
}
