package cricket.tournament.simulation.api.controller;

import cricket.tournament.simulation.CricketTournamentApplication;
import cricket.tournament.simulation.api.dto.request.TeamRequest;
import cricket.tournament.simulation.api.dto.response.TeamResponse;
import cricket.tournament.simulation.service.TeamService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/teams")
@Slf4j
public class TeamController {

    @Autowired
    TeamService teamService;

    @RequestMapping(value = "/createTeam", method = RequestMethod.POST)
    public void createTeam(@Valid @RequestBody TeamRequest teamRequest) {
        CricketTournamentApplication.LOGGER.info("Calling API createTeam(). teamRequest : {}", teamRequest);
        teamService.createTeam(teamRequest);
    }

    @GetMapping("/byTeamName")
    public TeamResponse getTeamByTeamName(@RequestParam String teamName) {
        CricketTournamentApplication.LOGGER.info("Calling API getTeamByTeamName(). teamName : {}", teamName);
        return teamService.getTeamByTeamName(teamName);
    }

    @GetMapping("/byPlayerName")
    public TeamResponse getTeamByPlayerName(@RequestParam String playerName) {
        CricketTournamentApplication.LOGGER.info("Calling API getTeamByPlayerName(). playerName : {}", playerName);
        return teamService.getTeamByPlayerName(playerName);
    }
}
