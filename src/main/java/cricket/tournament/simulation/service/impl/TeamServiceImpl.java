package cricket.tournament.simulation.service.impl;

import cricket.tournament.simulation.api.dto.request.RankingRequestResponse;
import cricket.tournament.simulation.api.dto.request.TeamRequest;
import cricket.tournament.simulation.api.dto.response.TeamResponse;
import cricket.tournament.simulation.enums.TeamEnum;
import cricket.tournament.simulation.exception.error.EntityNotFoundException;
import cricket.tournament.simulation.repository.model.Ranking;
import cricket.tournament.simulation.repository.model.Team;
import cricket.tournament.simulation.repository.repository.RankingRepository;
import cricket.tournament.simulation.repository.repository.TeamRepository;
import cricket.tournament.simulation.service.TeamService;
import cricket.tournament.simulation.service.converter.Converters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeamServiceImpl implements TeamService {

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
        Ranking ranking = new Ranking(teamSaved.getId(), rankingRequestResponse.getTestRanking(), rankingRequestResponse.getOdiRanking(), rankingRequestResponse.getT20Ranking());
        rankingRepository.save(ranking);
        Ranking rankingSaved = rankingRepository.findByTeamId(teamSaved.getId());
        teamSaved.setRankingId(rankingSaved.getId());
        teamRepository.save(teamSaved);
    }

    @Override
    public TeamResponse getTeamByTeamName(String teamName) {

        TeamEnum team = TeamEnum.getValue(teamName);
        if (team == null)
            throw new EntityNotFoundException(Team.class);

        Ranking ranking = converters.getRankingFromTeamName(teamName);
        RankingRequestResponse rankingRequestResponse = new RankingRequestResponse(ranking.getTestRanking(), ranking.getOdiRanking(), ranking.getT20Ranking());
        return new TeamResponse(teamName, rankingRequestResponse);
    }
}
