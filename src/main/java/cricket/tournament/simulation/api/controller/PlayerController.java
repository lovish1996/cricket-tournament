package cricket.tournament.simulation.api.controller;

import cricket.tournament.simulation.api.dto.request.PlayerRequest;
import cricket.tournament.simulation.api.dto.response.PlayerResponse;
import cricket.tournament.simulation.service.PlayerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

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

    @GetMapping("/byShirtIdAndTeamName")
    public PlayerResponse getPlayerByShirtIdAndTeamName(@RequestParam Long playerShirtId, @RequestParam String teamName) {
        return playerService.getPlayerByShirtIdAndTeamName(playerShirtId, teamName);
    }

    @GetMapping("/byPlayerName")
    public PlayerResponse getPlayerByName(@RequestParam String playerName) {
        return playerService.getPlayerByName(playerName);
    }

    @GetMapping("/byPositionOfResponsibilityAndTeamName")
    public PlayerResponse getPlayerByPositionOfResponsibilityAndTeamName(@RequestParam String positionOfResponsibility, @RequestParam String teamName) {
        return playerService.getPlayerByPositionOfResponsibilityAndTeamName(positionOfResponsibility, teamName);
    }

}
