package cricket.tournament.simulation.service.impl;

import cricket.tournament.simulation.api.dto.request.RankingRequestResponse;
import cricket.tournament.simulation.repository.model.Ranking;
import cricket.tournament.simulation.repository.repository.RankingRepository;
import cricket.tournament.simulation.repository.repository.TeamRepository;
import cricket.tournament.simulation.service.RankingService;
import cricket.tournament.simulation.service.converter.Converters;
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
    public RankingRequestResponse getRankingByTeamName(String teamName) {
        Ranking ranking = converters.getRankingFromTeamName(teamName);
        return new RankingRequestResponse(ranking.getTestRanking(), ranking.getOdiRanking(), ranking.getT20Ranking());
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
