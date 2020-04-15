package cricket.tournament.simulation.service;

import cricket.tournament.simulation.api.dto.request.RankingRequestResponse;
import cricket.tournament.simulation.api.dto.request.TeamListRequest;
import cricket.tournament.simulation.api.dto.request.TeamRequest;

public interface RankingService {

    void createRanking(TeamRequest teamRequest);

    void massUpdateRankings(TeamListRequest teamListRequest);

    RankingRequestResponse getRankingByTeamName(String teamName);

    Long getTestRankingForTeam(String teamName);

    Long getOdiRankingForTeam(String teamName);

    Long getT20RankingForTeam(String teamName);
}
