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
        uniqueConstraints = {@UniqueConstraint(columnNames = {"team_code"})}
)
public class Team extends BaseUpdateEntity implements Comparable<Team> {

    @NotNull
    @Column(name = "team_code")
    private Long teamCode;

    @NotNull
    @Column(name = "team_name")
    private String teamName;

    @Column(name = "ranking_id")
    private Long rankingId;

    @Override
    public int compareTo(Team o) {
        return this.getTeamCode().compareTo(o.getTeamCode());
    }
}
