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
@Table(name = "ranking_details",
        uniqueConstraints = {@UniqueConstraint(columnNames = {"test_ranking"}),
                @UniqueConstraint(columnNames = {"odi_ranking"}),
                @UniqueConstraint(columnNames = {"t20_ranking"})}
)
public class Ranking extends BaseUpdateEntity {

    @NotNull
    @Column(name = "team_id")
    private Long teamId;

    @Column(name = "test_ranking")
    private Long testRanking;

    @Column(name = "odi_ranking")
    private Long ODIRanking;

    @Column(name = "t20_ranking")
    private Long T20Ranking;
}
