package cricket.tournament.simulation.api.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class RankingRequestResponse extends BaseRequestDto {

    private Long testRanking;

    private Long odiRanking;

    private Long t20Ranking;
}
