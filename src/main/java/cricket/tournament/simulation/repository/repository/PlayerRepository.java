package cricket.tournament.simulation.repository.repository;

import cricket.tournament.simulation.enums.PlayerType;
import cricket.tournament.simulation.enums.PositionOfResponsibility;
import cricket.tournament.simulation.repository.model.Player;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PlayerRepository extends CrudRepository<Player,Long> {

    Player findByPlayerShirtId(Long playerShirtId);

    Player findByPlayerName(String playerName);

    List<Player> findAllByPlayerType(PlayerType playerType);

    Player findByPositionOfResponsibility(PositionOfResponsibility positionOfResponsibility);
}
