package cricket.tournament.simulation.service.converter;

import cricket.tournament.simulation.repository.dto.response.PlayerResponse;
import cricket.tournament.simulation.repository.model.Player;

import java.util.ArrayList;
import java.util.List;

public class PlayerConverters {

    public static PlayerResponse convertPlayerToPlayerResponse(Player player) {
        return new PlayerResponse(player.getPlayerShirtId(), player.getPlayerName(),
                player.getPlayerType().getPlayerType(), player.getPositionOfResponsibility().getPositionOfResponsibility(),
                player.getTeam().getTeamName());
    }

    public static List<PlayerResponse> convertPlayersToPlayerResponses(List<Player> players){
        List<PlayerResponse> playerResponses =  new ArrayList<>();

        for (Player player: players) {
            PlayerResponse playerResponse = new PlayerResponse(player.getPlayerShirtId(), player.getPlayerName(),
                    player.getPlayerType().getPlayerType(), player.getPositionOfResponsibility().getPositionOfResponsibility(),
                    player.getTeam().getTeamName());
            playerResponses.add(playerResponse);
        }
        return playerResponses;
    }
}
