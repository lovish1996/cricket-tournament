package cricket.tournament.simulation.service.impl;

import cricket.tournament.simulation.api.dto.request.PlayerRequest;
import cricket.tournament.simulation.api.dto.response.PlayerResponse;
import cricket.tournament.simulation.enums.PositionOfResponsibility;
import cricket.tournament.simulation.enums.TeamEnum;
import cricket.tournament.simulation.repository.model.Player;
import cricket.tournament.simulation.repository.model.Team;
import cricket.tournament.simulation.repository.repository.PlayerRepository;
import cricket.tournament.simulation.repository.repository.TeamRepository;
import cricket.tournament.simulation.service.PlayerService;
import cricket.tournament.simulation.service.converter.PlayerConverters;
import cricket.tournament.simulation.service.validation.PlayerValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PlayerServiceImpl implements PlayerService {

    @Autowired
    PlayerRepository playerRepository;
    @Autowired
    TeamRepository teamRepository;

    @Override
    public void createPlayer(PlayerRequest playerRequest) {
        if (!PlayerValidation.validatePlayer(playerRequest)) {
            return;
        }
        Long teamId = teamRepository.findByTeamCode(TeamEnum.getTeamCodeFromTeamName(playerRequest.getTeamName())).getId();
        playerRepository.save(PlayerConverters.convertPlayerRequestToPlayer(playerRequest, teamId));
    }

    @Override
    public PlayerResponse getPlayerByShirtIdAndTeamName(Long playerShirtId, String teamName) {
        if (!PlayerValidation.validateTeamName(teamName)) {
            return null;
        }
        Team team = getTeamFromTeamName(teamName);
        Player player = playerRepository.findByPlayerShirtIdAndTeamId(playerShirtId, team.getId());
        return PlayerConverters.convertPlayerToPlayerResponse(player, team.getTeamCode());
    }

    @Override
    public PlayerResponse getPlayerByName(String playerName) {
        Player player = playerRepository.findByPlayerName(playerName);
        Long teamCode = teamRepository.findById(player.getTeamId()).get().getTeamCode();
        return PlayerConverters.convertPlayerToPlayerResponse(player, teamCode);
    }

    @Override
    public List<PlayerResponse> getPlayersByPositionOfResponsibilityAndTeamName(String positionOfResponsibility, String teamName) {
        if (!PlayerValidation.validatePositionOfResponsibility(positionOfResponsibility) || !PlayerValidation.validateTeamName(teamName)) {
            return null;
        }
        Team team = getTeamFromTeamName(teamName);
        List<Player> players = playerRepository.findAll();
        List<Player> playersPORAndTeam = players.stream()
                .filter(player -> player.getTeamId().equals(team.getId()))
                .filter(player -> player.getPositionOfResponsibility() != null)
                .filter(player -> player.getPositionOfResponsibility().equals(PositionOfResponsibility.getValue(positionOfResponsibility)))
                .collect(Collectors.toList());
        return PlayerConverters.convertPlayersToPlayerResponses(playersPORAndTeam, team.getTeamCode());
    }

    @Override
    public List<PlayerResponse> getPlayersByTeamName(String teamName) {
        if (!PlayerValidation.validateTeamName(teamName)) {
            return null;
        }
        Team team = getTeamFromTeamName(teamName);
        List<Player> players = playerRepository.findAll();
        List<Player> playersTeam = players.stream()
                .filter(player -> player.getTeamId().equals(team.getId()))
                .collect(Collectors.toList());
        return PlayerConverters.convertPlayersToPlayerResponses(playersTeam, team.getTeamCode());
    }

    @Override
    public List<PlayerResponse> getPlayersByPlayerTypeAndTeamName(String playerType, String teamName) {
        if (!PlayerValidation.validatePlayerType(playerType) || !PlayerValidation.validateTeamName(teamName)) {
            return null;
        }
        Team team = getTeamFromTeamName(teamName);
        List<Player> players = playerRepository.findAll();
        List<Player> playersTeam = players.stream()
                .filter(player -> player.getTeamId().equals(team.getId()))
                .filter(player -> playerType.equalsIgnoreCase(player.getPlayerType().getPlayerType()))
                .collect(Collectors.toList());
        return PlayerConverters.convertPlayersToPlayerResponses(playersTeam, team.getTeamCode());
    }

    private Team getTeamFromTeamName(String teamName) {
        Long teamCode = TeamEnum.getTeamCodeFromTeamName(teamName);
        return teamRepository.findByTeamCode(teamCode);
    }

}
