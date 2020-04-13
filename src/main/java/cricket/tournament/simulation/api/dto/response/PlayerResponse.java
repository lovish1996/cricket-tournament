package cricket.tournament.simulation.api.dto.response;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class PlayerResponse {
    private Long playerShirtId;
    private String playerName;
    private String playerType;
    private String positionOfResponsibility;
    private String team;

    @JsonCreator
    public PlayerResponse(@JsonProperty("playerShirtId") Long playerShirtId,
                          @JsonProperty("playerName") String playerName,
                          @JsonProperty("playerType") String playerType,
                          @JsonProperty("positionOfResponsibility") String positionOfResponsibility,
                          @JsonProperty("team") String team) {
        this.playerShirtId = playerShirtId;
        this.playerName = playerName;
        this.playerType = playerType;
        this.positionOfResponsibility = positionOfResponsibility;
        this.team = team;
    }
}
