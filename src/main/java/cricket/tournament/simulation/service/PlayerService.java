package cricket.tournament.simulation.service;

import cricket.tournament.simulation.repository.dto.request.PlayerRequest;
import cricket.tournament.simulation.repository.dto.response.PlayerResponse;

import java.util.List;

public interface PlayerService {

    PlayerResponse getPlayerByShirtId(Long playerShirtId);

    void createPlayer(PlayerRequest playerrequest);

    PlayerResponse getPlayerByName(String playerName);

    PlayerResponse getPlayerByPositionOfResponsibility(String positionOfResponsibility);

    List<PlayerResponse> getAllPlayersByPlayerType(String playerType);
}
