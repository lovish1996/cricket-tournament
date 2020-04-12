package cricket.tournament.simulation.service;

import cricket.tournament.simulation.repository.dto.request.PlayerRequest;
import cricket.tournament.simulation.repository.dto.response.PlayerResponse;

public interface PlayerService {

    PlayerResponse getPlayerByShirtId(Long playerShirtId);

    void createPlayer(PlayerRequest playerrequest);
}
