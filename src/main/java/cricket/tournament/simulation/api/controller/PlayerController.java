package cricket.tournament.simulation.api.controller;

import cricket.tournament.simulation.repository.dto.response.PlayerResponse;
import cricket.tournament.simulation.service.PlayerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
}
