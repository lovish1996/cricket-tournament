package cricket.tournament.simulation.service.converter;

import cricket.tournament.simulation.enums.TeamEnum;
import cricket.tournament.simulation.repository.model.Ranking;
import cricket.tournament.simulation.repository.model.Team;
import cricket.tournament.simulation.repository.repository.RankingRepository;
import cricket.tournament.simulation.repository.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Converters {

    @Autowired
    private TeamRepository teamRepository;

    @Autowired
    private RankingRepository rankingRepository;

    public Ranking getRankingFromTeamName(String teamName) {
        Long teamCode = TeamEnum.getTeamCodeFromTeamName(teamName);
        Team team = teamRepository.findByTeamCode(teamCode);
        return rankingRepository.findByTeamId(team.getId());
    }
}
