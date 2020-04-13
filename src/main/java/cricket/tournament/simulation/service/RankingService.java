package cricket.tournament.simulation.service;

import cricket.tournament.simulation.api.dto.request.RankingRequestResponse;

public interface RankingService {

    RankingRequestResponse getRankingByTeamName(String teamName);

    Long getTestRankingForTeam(String teamName);

    Long getOdiRankingForTeam(String teamName);

    Long getT20RankingForTeam(String teamName);
}
