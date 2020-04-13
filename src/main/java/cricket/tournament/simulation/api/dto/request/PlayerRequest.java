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
public class PlayerRequest extends BaseRequestDto {
    @NotNull
    private Long playerShirtId;

    @NotNull
    private String playerName;

    @NotNull
    private String playerType;

    private String positionOfResponsibility;

    @NotNull
    private String teamName;
}
