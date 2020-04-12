package cricket.tournament.simulation.service.impl;

import cricket.tournament.simulation.enums.PlayerType;
import cricket.tournament.simulation.enums.PositionOfResponsibility;
import cricket.tournament.simulation.enums.Team;
import cricket.tournament.simulation.repository.dto.request.PlayerRequest;
import cricket.tournament.simulation.repository.dto.response.PlayerResponse;
import cricket.tournament.simulation.repository.model.Player;
import cricket.tournament.simulation.repository.repository.PlayerRepository;
import cricket.tournament.simulation.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlayerServiceImpl implements PlayerService {

    @Autowired
    PlayerRepository playerRepository;

    @Override
    public PlayerResponse getPlayerByShirtId(Long playerShirtId) {
        Player player = playerRepository.findByPlayerShirtId(playerShirtId);
        return convertPlayerToPlayerResponse(player);
    }

    private PlayerResponse convertPlayerToPlayerResponse(Player player) {
        return new PlayerResponse(player.getPlayerShirtId(), player.getPlayerName(),
                player.getPlayerType().getPlayerType(), player.getPositionOfResponsibility().getPositionOfResponsibility(),
                player.getTeam().getTeamName());
    }

    @Override
    public void createPlayer(PlayerRequest playerRequest) {
        Player player = new Player(playerRequest.getPlayerShirtId(), playerRequest.getPlayerName(),
                PlayerType.getValue(playerRequest.getPlayerType()), PositionOfResponsibility.getValue(playerRequest.getPositionOfResponsibility()),
                Team.getValue(playerRequest.getTeam()));
        playerRepository.save(player);
    }
}
