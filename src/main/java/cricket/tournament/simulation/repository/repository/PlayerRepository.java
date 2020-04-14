package cricket.tournament.simulation.repository.repository;

import cricket.tournament.simulation.repository.model.Player;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PlayerRepository extends CrudRepository<Player, Long> {

    Player findByPlayerShirtIdAndTeamId(Long playerShirtId, Long teamId);

    Player findByPlayerName(String playerName);

    List<Player> findAll();
}
