package cricket.tournament.simulation.service.impl;

import cricket.tournament.simulation.enums.PlayerType;
import cricket.tournament.simulation.enums.PositionOfResponsibility;
import cricket.tournament.simulation.enums.Team;
import cricket.tournament.simulation.repository.dto.request.PlayerRequest;
import cricket.tournament.simulation.repository.dto.response.PlayerResponse;
import cricket.tournament.simulation.repository.model.Player;
import cricket.tournament.simulation.repository.repository.PlayerRepository;
import cricket.tournament.simulation.service.PlayerService;
import cricket.tournament.simulation.service.converter.PlayerConverters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerServiceImpl implements PlayerService {

    @Autowired
    PlayerRepository playerRepository;

    @Override
    public PlayerResponse getPlayerByShirtId(Long playerShirtId) {
        Player player = playerRepository.findByPlayerShirtId(playerShirtId);
        return PlayerConverters.convertPlayerToPlayerResponse(player);
    }

    @Override
    public void createPlayer(PlayerRequest playerRequest) {
        Player player = new Player(playerRequest.getPlayerShirtId(), playerRequest.getPlayerName(),
                PlayerType.getValue(playerRequest.getPlayerType()), PositionOfResponsibility.getValue(playerRequest.getPositionOfResponsibility()),
                Team.getValue(playerRequest.getTeam()));
        playerRepository.save(player);
    }

    @Override
    public PlayerResponse getPlayerByName(String playerName) {
        Player player = playerRepository.findByPlayerName(playerName);
        return PlayerConverters.convertPlayerToPlayerResponse(player);
    }

    @Override
    public PlayerResponse getPlayerByPositionOfResponsibility(String positionOfResponsibility) {
        Player player = playerRepository.findByPositionOfResponsibility(PositionOfResponsibility.getValue(positionOfResponsibility));
        return PlayerConverters.convertPlayerToPlayerResponse(player);
    }

    @Override
    public List<PlayerResponse> getAllPlayersByPlayerType(String playerType) {
        List<Player> players = playerRepository.findByPlayerType(PlayerType.getValue(playerType));
        return PlayerConverters.convertPlayersToPlayerResponses(players);
    }
}
