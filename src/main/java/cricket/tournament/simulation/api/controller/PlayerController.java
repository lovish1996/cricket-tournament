package cricket.tournament.simulation.api.controller;

import cricket.tournament.simulation.repository.dto.request.PlayerRequest;
import cricket.tournament.simulation.repository.dto.response.PlayerResponse;
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

    @GetMapping("/byShirtId")
    public PlayerResponse getPlayerByShirtId(@RequestParam Long playerShirtId) {
        return playerService.getPlayerByShirtId(playerShirtId);
    }

    @RequestMapping(value = "/createPlayer", method = RequestMethod.POST)
    public void createPlayer(@Valid @RequestBody PlayerRequest playerRequest){
        playerService.createPlayer(playerRequest);
    }
}
