package cricket.tournament.simulation.repository.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

@Data
@EqualsAndHashCode(callSuper = false)
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "team_details",
        uniqueConstraints = {@UniqueConstraint(columnNames = {"team_name"})}
)
public class Team extends BaseUpdateEntity {

    @NotNull
    @Column(name = "team_name")
    private String teamName;

    @Column(name = "ranking_id")
    private Long rankingId;

}
