package cricket.tournament.simulation.repository.repository;

import cricket.tournament.simulation.enums.PositionOfResponsibility;
import cricket.tournament.simulation.repository.model.Player;
import org.springframework.data.repository.CrudRepository;

public interface PlayerRepository extends CrudRepository<Player, Long> {

    Player findByPlayerShirtIdAndTeamId(Long playerShirtId, Long teamId);

    Player findByPlayerName(String playerName);

    Player findByPositionOfResponsibilityAndTeamId(PositionOfResponsibility positionOfResponsibility, Long teamId);
}
