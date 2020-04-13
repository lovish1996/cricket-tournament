package cricket.tournament.simulation.service;

import cricket.tournament.simulation.api.dto.request.PlayerRequest;
import cricket.tournament.simulation.api.dto.response.PlayerResponse;

public interface PlayerService {

    void createPlayer(PlayerRequest playerRequest);

    PlayerResponse getPlayerByShirtIdAndTeamName(Long playerShirtId, String teamName);

    PlayerResponse getPlayerByName(String playerName);

    PlayerResponse getPlayerByPositionOfResponsibilityAndTeamName(String positionOfResponsibility, String teamName);

}
