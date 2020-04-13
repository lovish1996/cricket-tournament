package cricket.tournament.simulation.api.controller;

import cricket.tournament.simulation.repository.dto.request.PlayerRequest;
import cricket.tournament.simulation.repository.dto.response.PlayerResponse;
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

    @GetMapping("/byShirtId")
    public PlayerResponse getPlayerByShirtId(@RequestParam Long playerShirtId) {
        return playerService.getPlayerByShirtId(playerShirtId);
    }

    @RequestMapping(value = "/createPlayer", method = RequestMethod.POST)
    public void createPlayer(@Valid @RequestBody PlayerRequest playerRequest) {
        playerService.createPlayer(playerRequest);
    }

    @GetMapping("/byPlayerName")
    public PlayerResponse getPlayerByName(@RequestParam String playerName) {
        return playerService.getPlayerByName(playerName);
    }

    @GetMapping("/byPositionOfResponsibility")
    public PlayerResponse getPlayerByPositionOfResponsibility(@RequestParam String positionOfResponsibility) {
        return playerService.getPlayerByPositionOfResponsibility(positionOfResponsibility);
    }

    @GetMapping("/allPlayers/byPlayerType")
    public List<PlayerResponse> getAllPlayersByPlayerType(@RequestParam String playerType) {
        return playerService.getAllPlayersByPlayerType(playerType);
    }
}
