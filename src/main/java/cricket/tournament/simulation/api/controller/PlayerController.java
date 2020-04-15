package cricket.tournament.simulation.api.controller;

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
    public PlayerResponse getPlayerByShirtIdAndTeamName(@Valid @RequestParam Long playerShirtId, @Valid @RequestParam String teamName) throws EntityNotFoundException {
        return playerService.getPlayerByShirtIdAndTeamName(playerShirtId, teamName);
    }

    @GetMapping("/byPlayerName")
    public PlayerResponse getPlayerByName(@RequestParam String playerName) throws EntityNotFoundException {
        return playerService.getPlayerByName(playerName);
    }

    @GetMapping("/byPositionOfResponsibilityAndTeamName")
    public PlayerResponse getPlayerByPositionOfResponsibilityAndTeamName(@RequestParam String positionOfResponsibility, @RequestParam String teamName) {
        return playerService.getPlayerByPositionOfResponsibilityAndTeamName(positionOfResponsibility, teamName);
    }

}
