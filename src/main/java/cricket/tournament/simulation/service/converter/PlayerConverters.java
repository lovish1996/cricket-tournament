package cricket.tournament.simulation.service.converter;

import cricket.tournament.simulation.api.dto.request.PlayerRequest;
import cricket.tournament.simulation.api.dto.response.PlayerResponse;
import cricket.tournament.simulation.enums.PlayerType;
import cricket.tournament.simulation.enums.PositionOfResponsibility;
import cricket.tournament.simulation.enums.TeamEnum;
import cricket.tournament.simulation.repository.model.Player;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class PlayerConverters {

    public static PlayerResponse convertPlayerToPlayerResponse(Player player, Long teamCode) {
        return playerToPlayerResponseConverter(player, teamCode);
    }

    private static PlayerResponse playerToPlayerResponseConverter(Player player, Long teamCode) {
        Long playerShirtId = player.getPlayerShirtId();
        String playerName = player.getPlayerName();
        String playerType = player.getPlayerType() == null ? null : player.getPlayerType().getPlayerType();
        String positionOfResponsibility = player.getPositionOfResponsibility() == null ? null : player.getPositionOfResponsibility().getPositionOfResponsibility();
        String teamName = TeamEnum.getTeamNameFromTeamCode(teamCode);
        return new PlayerResponse(playerShirtId, playerName, playerType, positionOfResponsibility, teamName);
    }

    public static List<PlayerResponse> convertPlayersToPlayerResponses(List<Player> players, Long teamCode) {
        return playersToPlayerResponsesConverter(players,teamCode);
    }

    private static List<PlayerResponse> playersToPlayerResponsesConverter(List<Player> players, Long teamCode) {
        return players.stream().map(player -> playerToPlayerResponseConverter(player,teamCode)).collect(Collectors.toList());
    }

    public static Player convertPlayerRequestToPlayer(PlayerRequest playerRequest, Long teamId) {
        return playerRequestToPlayerConverter(playerRequest, teamId);
    }

    private static Player playerRequestToPlayerConverter(PlayerRequest playerRequest, Long teamId) {
        Long playerShirtId = playerRequest.getPlayerShirtId();
        String playerName = playerRequest.getPlayerName();
        PlayerType playerType = PlayerType.getValue(playerRequest.getPlayerType());
        PositionOfResponsibility positionOfResponsibility = PositionOfResponsibility.getValue(playerRequest.getPositionOfResponsibility());
        return new Player(playerShirtId, playerName, playerType, positionOfResponsibility, teamId);
    }

}
