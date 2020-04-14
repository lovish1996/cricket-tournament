package cricket.tournament.simulation.repository.model;

import cricket.tournament.simulation.enums.PlayerType;
import cricket.tournament.simulation.enums.PositionOfResponsibility;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Index;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

@Data
@EqualsAndHashCode(callSuper = false)
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "player_details",
        uniqueConstraints = {@UniqueConstraint(columnNames = {"player_shirt_id", "team_id"})}
        ,
        indexes = {
                @Index(name = "positionOfResponsibilityIdx", columnList = "position_of_responsibility")
        }
)
public class Player extends BaseUpdateEntity {

    @NotNull
    @Column(name = "player_shirt_id")
    private Long playerShirtId;

    @NotNull
    @Column(name = "player_name")
    private String playerName;

    @NotNull
    @Column(name = "player_type")
    @Enumerated(EnumType.STRING)
    private PlayerType playerType;

    @Column(name = "position_of_responsibility")
    @Enumerated(EnumType.STRING)
    private PositionOfResponsibility positionOfResponsibility;

    @Column(name = "team_id")
    private Long teamId;
}
