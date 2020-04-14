package cricket.tournament.simulation.service;

import cricket.tournament.simulation.api.dto.request.PlayerRequest;
import cricket.tournament.simulation.api.dto.response.PlayerResponse;

import java.util.List;

public interface PlayerService {

    void createPlayer(PlayerRequest playerRequest);

    PlayerResponse getPlayerByShirtIdAndTeamName(Long playerShirtId, String teamName);

    PlayerResponse getPlayerByName(String playerName);

    List<PlayerResponse> getPlayersByPositionOfResponsibilityAndTeamName(String positionOfResponsibility, String teamName);

    List<PlayerResponse> getPlayersByTeamName(String teamName);

    List<PlayerResponse> getPlayersByPlayerTypeAndTeamName(String playerType, String teamName);
}
