package cricket.tournament.simulation.api.dto.response;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import cricket.tournament.simulation.api.dto.request.RankingRequestResponse;
import lombok.Getter;

@Getter
public class TeamResponse {

    private String teamName;
    private RankingRequestResponse rankingRequestResponse;

    @JsonCreator
    public TeamResponse(@JsonProperty("teamName") String teamName,
                        @JsonProperty("rankings") RankingRequestResponse rankingRequestResponse) {
        this.teamName = teamName;
        this.rankingRequestResponse = rankingRequestResponse;
    }
}
