package cricket.tournament.simulation.repository.repository;

import cricket.tournament.simulation.repository.model.Team;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TeamRepository extends CrudRepository<Team, Long> {

    Team findByTeamCode(Long teamCode);

    List<Team> findAll();
}
