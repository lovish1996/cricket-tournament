package cricket.tournament.simulation.api.controller;

import cricket.tournament.simulation.CricketTournamentApplication;
import cricket.tournament.simulation.api.dto.request.PlayerRequest;
import cricket.tournament.simulation.api.dto.response.PlayerResponse;
import cricket.tournament.simulation.exception.error.EntityNotFoundException;
import cricket.tournament.simulation.service.PlayerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/players")
@Slf4j
public class PlayerController {

    @Autowired
    PlayerService playerService;

    @RequestMapping(value = "/createPlayer", method = RequestMethod.POST)
    public void createPlayer(@Valid @RequestBody PlayerRequest playerRequest) {
        CricketTournamentApplication.LOGGER.info("Calling API createPlayer(). playerRequest : {}", playerRequest);
        playerService.createPlayer(playerRequest);
    }

    @GetMapping("/byShirtIdAndTeamName")
    public PlayerResponse getPlayerByShirtIdAndTeamName(@Valid @RequestParam Long playerShirtId, @Valid @RequestParam String teamName) throws EntityNotFoundException {
        return playerService.getPlayerByShirtIdAndTeamName(playerShirtId, teamName);
    }

    @GetMapping("/byPlayerName")
    public PlayerResponse getPlayerByName(@RequestParam String playerName) throws EntityNotFoundException {

    @GetMapping("/playerByShirtIdAndTeamName")
    public PlayerResponse getPlayerByShirtIdAndTeamName(@RequestParam Long playerShirtId, @RequestParam String teamName) throws EntityNotFoundException{
        CricketTournamentApplication.LOGGER.info("Calling API getPlayerByShirtIdAndTeamName(). playerShirtId : {}, teamName : {}", playerShirtId, teamName);
        return playerService.getPlayerByShirtIdAndTeamName(playerShirtId, teamName);
    }

    @GetMapping("/playerByPlayerName")
    public PlayerResponse getPlayerByName(@RequestParam String playerName) throws EntityNotFoundException{
        CricketTournamentApplication.LOGGER.info("Calling API getPlayerByName(). playerName : {}", playerName);
        return playerService.getPlayerByName(playerName);
    }

    @GetMapping("/playersByPositionOfResponsibilityAndTeamName")
    public List<PlayerResponse> getPlayerByPositionOfResponsibilityAndTeamName(@RequestParam String positionOfResponsibility, @RequestParam String teamName) {
        CricketTournamentApplication.LOGGER.info("Calling API getPlayerByPositionOfResponsibilityAndTeamName(). positionOfResponsibility : {}, teamName : {}", positionOfResponsibility, teamName);
        return playerService.getPlayersByPositionOfResponsibilityAndTeamName(positionOfResponsibility, teamName);
    }

    @GetMapping("/playersByTeamName")
    public List<PlayerResponse> getPlayersByTeamName(@RequestParam String teamName) {
        CricketTournamentApplication.LOGGER.info("Calling API getPlayersByTeamName(). teamName :{}", teamName);
        return playerService.getPlayersByTeamName(teamName);
    }

    @GetMapping("/playersByPlayerTypeAndTeamName")
    public List<PlayerResponse> getPlayersByPlayerTypeAndTeamName(@RequestParam String playerType, @RequestParam String teamName) {
        CricketTournamentApplication.LOGGER.info("Calling API getPlayersByPlayerTypeAndTeamName(). playerType : {}, teamName : {}", playerType, teamName);
        return playerService.getPlayersByPlayerTypeAndTeamName(playerType, teamName);
    }
}
