package cricket.tournament.simulation.service;

import cricket.tournament.simulation.api.dto.request.RankingRequestResponse;
import cricket.tournament.simulation.api.dto.request.TeamRequest;
import cricket.tournament.simulation.api.dto.response.TeamResponse;

public interface TeamService {

    void createTeam(TeamRequest teamRequest);

    TeamResponse getTeamByTeamName(String teamName);
}
