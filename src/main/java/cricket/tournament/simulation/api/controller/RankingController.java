package cricket.tournament.simulation.api.controller;

import cricket.tournament.simulation.CricketTournamentApplication;
import cricket.tournament.simulation.api.dto.request.RankingRequestResponse;
import cricket.tournament.simulation.api.dto.request.TeamListRequest;
import cricket.tournament.simulation.api.dto.request.TeamRequest;
import cricket.tournament.simulation.service.RankingService;
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
@RequestMapping("/rankings")
@Slf4j
public class RankingController {

    @Autowired
    RankingService rankingService;

    @RequestMapping(value = "/createRanking", method = RequestMethod.POST)
    public void createRanking(@Valid @RequestBody TeamRequest teamRequest) {
        CricketTournamentApplication.LOGGER.info("Calling API createRanking(). teamRequest : {}", teamRequest);
        rankingService.createRanking(teamRequest);
    }

    @RequestMapping(value = "/massUpdateRankings", method = RequestMethod.POST)
    public void massUpdateRankings(@Valid @RequestBody TeamListRequest teamListRequest) {
        CricketTournamentApplication.LOGGER.info("Calling API massUpdateRankings(). teamListRequest : {}", teamListRequest);
        rankingService.massUpdateRankings(teamListRequest);
    }

    @GetMapping("/byTeamName")
    public RankingRequestResponse getRankingByTeamName(@RequestParam String teamName) {
        CricketTournamentApplication.LOGGER.info("Calling API getRankingByTeamName(). teamName : {}", teamName);
        return rankingService.getRankingByTeamName(teamName);
    }

    @GetMapping("/byTestRankingForTeam")
    public Long getTestRankingForTeam(@RequestParam String teamName) {
        CricketTournamentApplication.LOGGER.info("Calling API getTestRankingForTeam(). teamName : {}", teamName);
        return rankingService.getTestRankingForTeam(teamName);
    }

    @GetMapping("/byOdiRankingForTeam")
    public Long getOdiRankingForTeam(@RequestParam String teamName) {
        CricketTournamentApplication.LOGGER.info("Calling API getOdiRankingForTeam(). teamName : {}", teamName);
        return rankingService.getOdiRankingForTeam(teamName);
    }

    @GetMapping("/byT20RankingForTeam")
    public Long getT20RankingForTeam(@RequestParam String teamName) {
        CricketTournamentApplication.LOGGER.info("Calling API getT20RankingForTeam(). teamName : {}", teamName);
        return rankingService.getT20RankingForTeam(teamName);
    }

}
