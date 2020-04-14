package cricket.tournament.simulation.service;

import cricket.tournament.simulation.api.dto.request.RankingRequestResponse;
import cricket.tournament.simulation.api.dto.request.TeamRequest;

public interface RankingService {

    void createRanking(TeamRequest teamRequest);

    RankingRequestResponse getRankingByTeamName(String teamName);

    Long getTestRankingForTeam(String teamName);

    Long getOdiRankingForTeam(String teamName);

    Long getT20RankingForTeam(String teamName);

}
