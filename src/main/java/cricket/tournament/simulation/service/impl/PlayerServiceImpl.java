package cricket.tournament.simulation.service.impl;

import cricket.tournament.simulation.api.dto.request.PlayerRequest;
import cricket.tournament.simulation.api.dto.response.PlayerResponse;
import cricket.tournament.simulation.enums.PositionOfResponsibility;
import cricket.tournament.simulation.enums.TeamEnum;
import cricket.tournament.simulation.exception.error.EntityNotFoundException;
import cricket.tournament.simulation.repository.model.Player;
import cricket.tournament.simulation.repository.model.Team;
import cricket.tournament.simulation.repository.repository.PlayerRepository;
import cricket.tournament.simulation.repository.repository.TeamRepository;
import cricket.tournament.simulation.service.PlayerService;
import cricket.tournament.simulation.service.converter.PlayerConverters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

@Service
public class PlayerServiceImpl implements PlayerService {

    @Autowired
    PlayerRepository playerRepository;
    @Autowired
    TeamRepository teamRepository;

    @Override
    public void createPlayer(PlayerRequest playerRequest) {
        Long teamId = teamRepository.findByTeamCode(TeamEnum.getTeamCodeFromTeamName(playerRequest.getTeamName())).getId();
        playerRepository.save(PlayerConverters.convertPlayerRequestToPlayer(playerRequest, teamId));
    }

    @Override
    public PlayerResponse getPlayerByShirtIdAndTeamName(Long playerShirtId, String teamName) throws EntityNotFoundException{
        Team team = getTeamFromTeamName(teamName);
        Player player = playerRepository.findByPlayerShirtIdAndTeamId(playerShirtId, team.getId());
        if(player==null){
            throw new EntityNotFoundException(Player.class);
        }
        return PlayerConverters.convertPlayerToPlayerResponse(player, team.getTeamCode());

    }

    @Override
    public PlayerResponse getPlayerByName(String playerName) throws EntityNotFoundException {
        Player player = playerRepository.findByPlayerName(playerName);
        if(player==null){
            throw new EntityNotFoundException(Player.class);
        }
        Long teamCode = teamRepository.findById(player.getTeamId()).get().getTeamCode();
        return PlayerConverters.convertPlayerToPlayerResponse(player, teamCode);
    }

    @Override
    public PlayerResponse getPlayerByPositionOfResponsibilityAndTeamName(String positionOfResponsibility, String teamName) {
        Team team = getTeamFromTeamName(teamName);
        Player player = playerRepository.findByPositionOfResponsibilityAndTeamId(PositionOfResponsibility.getValue(positionOfResponsibility), team.getId());
        return PlayerConverters.convertPlayerToPlayerResponse(player, team.getTeamCode());
    }

    private Team getTeamFromTeamName(String teamName) {
        Long teamCode = TeamEnum.getTeamCodeFromTeamName(teamName);

        return teamRepository.findByTeamCode(teamCode);
    }
}
