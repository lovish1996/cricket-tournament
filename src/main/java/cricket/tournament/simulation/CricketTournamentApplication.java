package cricket.tournament.simulation;

import cricket.tournament.simulation.enums.Team;
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

    public static void main(String[] args) {
        for (Team team : Team.values()) {
            System.out.println(team.getTeamCode() + " " + team.getTeamName());
        }
        SpringApplication.run(CricketTournamentApplication.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(CricketTournamentApplication.class);
    }
}
