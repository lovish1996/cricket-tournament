package cricket.tournament.simulation.api.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class TeamRequest extends BaseRequestDto {

    @NotNull
    private String teamName;

    private RankingRequestResponse rankingRequestResponse;

}
