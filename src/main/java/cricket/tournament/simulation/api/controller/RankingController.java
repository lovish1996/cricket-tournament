package cricket.tournament.simulation.api.controller;

import cricket.tournament.simulation.api.dto.request.RankingRequestResponse;
import cricket.tournament.simulation.service.RankingService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rankings")
@Slf4j
public class RankingController {

    @Autowired
    RankingService rankingService;

    @GetMapping("/byTeamName")
    public RankingRequestResponse getRankingByTeamName(@RequestParam String teamName) {
        return rankingService.getRankingByTeamName(teamName);
    }

    @GetMapping("/byTestRankingForTeam")
    public Long getTestRankingForTeam(@RequestParam String teamName) {
        return rankingService.getTestRankingForTeam(teamName);
    }

    @GetMapping("/byOdiRankingForTeam")
    public Long getOdiRankingForTeam(@RequestParam String teamName) {
        return rankingService.getOdiRankingForTeam(teamName);
    }

    @GetMapping("/byT20RankingForTeam")
    public Long getT20RankingForTeam(@RequestParam String teamName) {
        return rankingService.getT20RankingForTeam(teamName);
    }

}
