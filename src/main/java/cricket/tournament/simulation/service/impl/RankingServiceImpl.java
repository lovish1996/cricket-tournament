package cricket.tournament.simulation.service.impl;

import cricket.tournament.simulation.api.dto.request.RankingRequestResponse;
import cricket.tournament.simulation.api.dto.request.TeamRequest;
import cricket.tournament.simulation.enums.TeamEnum;
import cricket.tournament.simulation.repository.model.Ranking;
import cricket.tournament.simulation.repository.model.Team;
import cricket.tournament.simulation.repository.repository.RankingRepository;
import cricket.tournament.simulation.repository.repository.TeamRepository;
import cricket.tournament.simulation.service.RankingService;
import cricket.tournament.simulation.service.converter.Converters;
import cricket.tournament.simulation.service.converter.RankingConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RankingServiceImpl implements RankingService {

    @Autowired
    TeamRepository teamRepository;

    @Autowired
    RankingRepository rankingRepository;

    @Autowired
    Converters converters;

    @Override
    public void createRanking(TeamRequest teamRequest) {
        Team team = teamRepository.findByTeamCode(TeamEnum.getTeamCodeFromTeamName(teamRequest.getTeamName()));
        RankingRequestResponse rankingRequestResponse = teamRequest.getRankingRequestResponse();
        if (team.getRankingId() == null) {
            Ranking ranking = RankingConverter.convertRankingRequestResponseToRanking(team.getId(), rankingRequestResponse);
            Ranking rankingSaved = rankingRepository.save(ranking);
            team.setRankingId(rankingSaved.getId());
            teamRepository.save(team);
        } else {
            Ranking rankingSaved = rankingRepository.findByTeamId(team.getId());
            RankingConverter.updateRankingFromRankingRequestResponse(rankingSaved, rankingRequestResponse);
            rankingRepository.save(rankingSaved);
        }
    }

    @Override
    public RankingRequestResponse getRankingByTeamName(String teamName) {
        Ranking ranking = converters.getRankingFromTeamName(teamName);
        return RankingConverter.convertRankingToRankingRequestResponse(ranking);
    }

    @Override
    public Long getTestRankingForTeam(String teamName) {
        Ranking ranking = converters.getRankingFromTeamName(teamName);
        return ranking.getTestRanking();
    }

    @Override
    public Long getOdiRankingForTeam(String teamName) {
        Ranking ranking = converters.getRankingFromTeamName(teamName);
        return ranking.getOdiRanking();
    }

    @Override
    public Long getT20RankingForTeam(String teamName) {
        Ranking ranking = converters.getRankingFromTeamName(teamName);
        return ranking.getT20Ranking();
    }
}
