package cricket.tournament.simulation.repository.repository;

import cricket.tournament.simulation.enums.PlayerType;
import cricket.tournament.simulation.enums.PositionOfResponsibility;
import cricket.tournament.simulation.repository.model.Player;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PlayerRepository extends CrudRepository<Player, Long> {

    Player findByPlayerShirtId(Long playerShirtId);

    Player findByPlayerName(String playerName);

    //    @Query(
//            nativeQuery = true,
//            value =
//                    "select * from player_details where player_type= :playerType")
    List<Player> findByPlayerType(PlayerType playerType);

    Player findByPositionOfResponsibility(PositionOfResponsibility positionOfResponsibility);
}
