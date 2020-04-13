package cricket.tournament.simulation.service;

import cricket.tournament.simulation.api.dto.request.PlayerRequest;
import cricket.tournament.simulation.api.dto.response.PlayerResponse;

import java.util.List;

public interface PlayerService {

    PlayerResponse getPlayerByShirtId(Long playerShirtId);

    void createPlayer(PlayerRequest playerRequest);

    PlayerResponse getPlayerByName(String playerName);

    PlayerResponse getPlayerByPositionOfResponsibility(String positionOfResponsibility);

    List<PlayerResponse> getAllPlayersByPlayerType(String playerType);
}
