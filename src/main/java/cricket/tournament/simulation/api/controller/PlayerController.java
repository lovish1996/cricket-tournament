package cricket.tournament.simulation.api.controller;

import cricket.tournament.simulation.api.dto.request.PlayerRequest;
import cricket.tournament.simulation.api.dto.response.PlayerResponse;
import cricket.tournament.simulation.exception.error.EntityNotFoundException;
import cricket.tournament.simulation.service.PlayerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.web.bind.annotation.*;

import javax.validation.ConstraintViolationException;
import javax.validation.Valid;
import java.sql.SQLIntegrityConstraintViolationException;

@RestController
@RequestMapping("/players")
@Slf4j
public class PlayerController {

    @Autowired
    PlayerService playerService;

    @RequestMapping(value = "/createPlayer", method = RequestMethod.POST)
    public void createPlayer(@Valid @RequestBody PlayerRequest playerRequest) throws DataIntegrityViolationException{
        try{
            playerService.createPlayer(playerRequest);
        }
        catch (DataIntegrityViolationException e){
            throw e;
        }
    }

    @GetMapping("/byShirtIdAndTeamName")
    public PlayerResponse getPlayerByShirtIdAndTeamName(@Valid @RequestParam Long playerShirtId, @Valid @RequestParam String teamName) throws EntityNotFoundException{
        try{
            return playerService.getPlayerByShirtIdAndTeamName(playerShirtId, teamName);
        }
        catch (EntityNotFoundException ex){
            throw ex;
        }
    }

    @GetMapping("/byPlayerName")
    public PlayerResponse getPlayerByName(@RequestParam String playerName) throws EntityNotFoundException {
        try{
            return playerService.getPlayerByName(playerName);
        }
        catch(EntityNotFoundException ex){
            throw ex;
        }
    }

    @GetMapping("/byPositionOfResponsibilityAndTeamName")
    public PlayerResponse getPlayerByPositionOfResponsibilityAndTeamName(@RequestParam String positionOfResponsibility, @RequestParam String teamName) {
        return playerService.getPlayerByPositionOfResponsibilityAndTeamName(positionOfResponsibility, teamName);
    }

}
