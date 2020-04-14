package cricket.tournament.simulation.api.controller;

import cricket.tournament.simulation.api.dto.request.PlayerRequest;
import cricket.tournament.simulation.api.dto.response.PlayerResponse;
import cricket.tournament.simulation.service.PlayerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
        playerService.createPlayer(playerRequest);
    }

    @GetMapping("/playerByShirtIdAndTeamName")
    public PlayerResponse getPlayerByShirtIdAndTeamName(@RequestParam Long playerShirtId, @RequestParam String teamName) {
        return playerService.getPlayerByShirtIdAndTeamName(playerShirtId, teamName);
    }

    @GetMapping("/playerByPlayerName")
    public PlayerResponse getPlayerByName(@RequestParam String playerName) {
        return playerService.getPlayerByName(playerName);
    }

    @GetMapping("/playersByPositionOfResponsibilityAndTeamName")
    public List<PlayerResponse> getPlayerByPositionOfResponsibilityAndTeamName(@RequestParam String positionOfResponsibility, @RequestParam String teamName) {
        return playerService.getPlayersByPositionOfResponsibilityAndTeamName(positionOfResponsibility, teamName);
    }

    @GetMapping("/playersByTeamName")
    public List<PlayerResponse> getPlayersByTeamName(@RequestParam String teamName) {
        return playerService.getPlayersByTeamName(teamName);
    }

    @GetMapping("/playersByPlayerTypeAndTeamName")
    public List<PlayerResponse> getPlayersByPlayerTypeAndTeamName(@RequestParam String playerType, @RequestParam String teamName) {
        return playerService.getPlayersByPlayerTypeAndTeamName(playerType, teamName);
    }
}
