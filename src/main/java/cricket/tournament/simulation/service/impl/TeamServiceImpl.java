package cricket.tournament.simulation.service.impl;

import cricket.tournament.simulation.api.dto.request.RankingRequestResponse;
import cricket.tournament.simulation.api.dto.request.TeamRequest;
import cricket.tournament.simulation.api.dto.response.TeamResponse;
import cricket.tournament.simulation.enums.TeamEnum;
import cricket.tournament.simulation.repository.model.Player;
import cricket.tournament.simulation.repository.model.Ranking;
import cricket.tournament.simulation.repository.model.Team;
import cricket.tournament.simulation.repository.repository.PlayerRepository;
import cricket.tournament.simulation.repository.repository.RankingRepository;
import cricket.tournament.simulation.repository.repository.TeamRepository;
import cricket.tournament.simulation.service.TeamService;
import cricket.tournament.simulation.service.converter.Converters;
import cricket.tournament.simulation.service.converter.RankingConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TeamServiceImpl implements TeamService {

    @Autowired
    PlayerRepository playerRepository;

    @Autowired
    TeamRepository teamRepository;

    @Autowired
    RankingRepository rankingRepository;

    @Autowired
    Converters converters;

    @Override
    public void createTeam(TeamRequest teamRequest) {

        Long teamCode = TeamEnum.getTeamCodeFromTeamName(teamRequest.getTeamName());
        Team team = new Team(teamCode, teamRequest.getTeamName(), null);
        teamRepository.save(team);
        Team teamSaved = teamRepository.findByTeamCode(teamCode);
        RankingRequestResponse rankingRequestResponse = teamRequest.getRankingRequestResponse();
        Ranking ranking = RankingConverter.convertRankingRequestResponseToRanking(teamSaved.getId(), rankingRequestResponse);
        rankingRepository.save(ranking);
        Ranking rankingSaved = rankingRepository.findByTeamId(teamSaved.getId());
        teamSaved.setRankingId(rankingSaved.getId());
        teamRepository.save(teamSaved);
    }

    @Override
    public TeamResponse getTeamByTeamName(String teamName) {
        Ranking ranking = converters.getRankingFromTeamName(teamName);
        RankingRequestResponse rankingRequestResponse = RankingConverter.convertRankingToRankingRequestResponse(ranking);
        return new TeamResponse(teamName, rankingRequestResponse);
    }

    @Override
    public TeamResponse getTeamByPlayerName(String playerName) {
        Player player = playerRepository.findByPlayerName(playerName);
        Optional<Team> team = teamRepository.findById(player.getTeamId());
        if (team.isPresent()) {
            String teamName = team.get().getTeamName();
            Ranking ranking = converters.getRankingFromTeamName(teamName);
            RankingRequestResponse rankingRequestResponse = RankingConverter.convertRankingToRankingRequestResponse(ranking);
            return new TeamResponse(teamName, rankingRequestResponse);
        }
        return null;
    }
}
