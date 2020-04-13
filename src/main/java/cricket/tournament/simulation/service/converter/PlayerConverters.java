package cricket.tournament.simulation.service.converter;

import cricket.tournament.simulation.repository.dto.response.PlayerResponse;
import cricket.tournament.simulation.repository.model.Player;

import java.util.ArrayList;
import java.util.List;

public class PlayerConverters {

    public static PlayerResponse convertPlayerToPlayerResponse(Player player) {
        return processPlayerClass(player);
    }

    public static List<PlayerResponse> convertPlayersToPlayerResponses(List<Player> players) {
        List<PlayerResponse> playerResponses = new ArrayList<>();

        for (Player player : players) {
            playerResponses.add(processPlayerClass(player));
        }
        return playerResponses;
    }

    private static PlayerResponse processPlayerClass(Player player) {
        Long playerShirtId = player.getPlayerShirtId();
        String playerName = player.getPlayerName();
        String playerType = player.getPlayerType() == null ? null : player.getPlayerType().getPlayerType();
        String positionOfResponsibility = player.getPositionOfResponsibility() == null ? null : player.getPositionOfResponsibility().getPositionOfResponsibility();
        String teamName = player.getTeam() == null ? null : player.getTeam().getTeamName();
        return new PlayerResponse(playerShirtId, playerName, playerType, positionOfResponsibility, teamName);
    }
}
