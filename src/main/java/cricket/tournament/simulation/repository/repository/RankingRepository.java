package cricket.tournament.simulation.repository.repository;

import cricket.tournament.simulation.repository.model.Ranking;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RankingRepository extends CrudRepository<Ranking, Long> {

    Ranking findByTeamId(Long teamId);

    List<Ranking> findAll();
}
