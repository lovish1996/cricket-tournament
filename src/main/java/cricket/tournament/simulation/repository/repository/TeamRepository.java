package cricket.tournament.simulation.repository.repository;

import cricket.tournament.simulation.repository.model.Team;
import org.springframework.data.repository.CrudRepository;

public interface TeamRepository extends CrudRepository<Team, Long> {
    Team findByTeamCode(Long teamCode);
}
