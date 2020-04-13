package cricket.tournament.simulation.service.converter;

import cricket.tournament.simulation.enums.PlayerType;
import cricket.tournament.simulation.enums.PositionOfResponsibility;
import cricket.tournament.simulation.enums.Team;
import cricket.tournament.simulation.api.dto.request.PlayerRequest;
import cricket.tournament.simulation.api.dto.response.PlayerResponse;
import cricket.tournament.simulation.repository.model.Player;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PlayerConverters {

    /**
     * Utility method for converting Player to PlayerResponse
     *
     * @param player
     * @return playerResponse
     */
    public static PlayerResponse convertPlayerToPlayerResponse(Player player) {
        return playerToPlayerResponseConverter(player);
    }

    /**
     * Utility method for converting list of Player to list of PlayerResponse
     *
     * @param players
     * @return playerResponses
     */
    public static List<PlayerResponse> convertPlayersToPlayerResponses(List<Player> players) {
        List<PlayerResponse> playerResponses = new ArrayList<>();

        for (Player player : players) {
            playerResponses.add(playerToPlayerResponseConverter(player));
        }
        return playerResponses;
    }

    /**
     * Converter method for converting Player to PlayerResponse
     *
     * @param player
     * @return playerResponse
     */
    private static PlayerResponse playerToPlayerResponseConverter(Player player) {
        Long playerShirtId = player.getPlayerShirtId();
        String playerName = player.getPlayerName();
        String playerType = player.getPlayerType() == null ? null : player.getPlayerType().getPlayerType();
        String positionOfResponsibility = player.getPositionOfResponsibility() == null ? null : player.getPositionOfResponsibility().getPositionOfResponsibility();
        assert Team.getValue(player.getTeamId()) != null;
        String teamName = player.getTeamId() == null ? null : Team.getValue(player.getTeamId()).getTeamName();
        return new PlayerResponse(playerShirtId, playerName, playerType, positionOfResponsibility, teamName);
    }

    /**
     * Utility method for converting PlayerRequest to Player
     *
     * @param playerRequest
     * @return player
     */
    public static Player convertPlayerRequestToPlayer(PlayerRequest playerRequest, Long teamId) {
        return playerRequestToPlayerConverter(playerRequest, teamId);
    }

    /**
     * Converter method for converting PlayerRequest to Player
     *
     * @param playerRequest
     * @return player
     */
    private static Player playerRequestToPlayerConverter(PlayerRequest playerRequest, Long teamId) {
        Long playerShirtId = playerRequest.getPlayerShirtId();
        String playerName = playerRequest.getPlayerName();
        PlayerType playerType = PlayerType.getValue(playerRequest.getPlayerType());
        PositionOfResponsibility positionOfResponsibility = PositionOfResponsibility.getValue(playerRequest.getPositionOfResponsibility());
        return new Player(playerShirtId, playerName, playerType, positionOfResponsibility, teamId);
    }

}
