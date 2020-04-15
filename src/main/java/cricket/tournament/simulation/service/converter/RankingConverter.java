package cricket.tournament.simulation.service.converter;

import cricket.tournament.simulation.api.dto.request.RankingRequestResponse;
import cricket.tournament.simulation.repository.model.Ranking;
import org.springframework.stereotype.Component;

@Component
public class RankingConverter {
    public static RankingRequestResponse convertRankingToRankingRequestResponse(Ranking ranking) {
        return new RankingRequestResponse(ranking.getTestRanking(), ranking.getOdiRanking(), ranking.getT20Ranking());
    }

    public static Ranking convertRankingRequestResponseToRanking(Long teamId, RankingRequestResponse rankingRequestResponse) {
        return new Ranking(teamId, rankingRequestResponse.getTestRanking(), rankingRequestResponse.getOdiRanking(), rankingRequestResponse.getT20Ranking());
    }

    public static Ranking updateRankingFromRankingRequestResponse(Ranking ranking, RankingRequestResponse rankingRequestResponse) {
        ranking.setTestRanking(rankingRequestResponse.getTestRanking());
        ranking.setOdiRanking(rankingRequestResponse.getOdiRanking());
        ranking.setT20Ranking(rankingRequestResponse.getT20Ranking());
        return ranking;
    }
}
