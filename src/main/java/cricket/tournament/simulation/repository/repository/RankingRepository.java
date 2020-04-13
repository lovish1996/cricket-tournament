package cricket.tournament.simulation.repository.repository;

import cricket.tournament.simulation.repository.model.Ranking;
import org.springframework.data.repository.CrudRepository;

public interface RankingRepository extends CrudRepository<Ranking, Long> {

    Ranking findByODIRanking(Long ranking);

    Ranking findByTestRanking(Long ranking);

    Ranking findByT20Ranking(Long ranking);

}
