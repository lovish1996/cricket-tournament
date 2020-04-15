package cricket.tournament.simulation.service.impl;

import cricket.tournament.simulation.api.dto.request.RankingRequestResponse;
import cricket.tournament.simulation.api.dto.request.TeamListRequest;
import cricket.tournament.simulation.api.dto.request.TeamRequest;
import cricket.tournament.simulation.enums.TeamEnum;
import cricket.tournament.simulation.repository.model.Ranking;
import cricket.tournament.simulation.repository.model.Team;
import cricket.tournament.simulation.repository.repository.RankingRepository;
import cricket.tournament.simulation.repository.repository.TeamRepository;
import cricket.tournament.simulation.service.RankingService;
import cricket.tournament.simulation.service.converter.Converters;
import cricket.tournament.simulation.service.converter.RankingConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class RankingServiceImpl implements RankingService {

    @Autowired
    TeamRepository teamRepository;

    @Autowired
    RankingRepository rankingRepository;

    @Autowired
    Converters converters;

    @Override
    public void createRanking(TeamRequest teamRequest) {
        Team team = teamRepository.findByTeamCode(TeamEnum.getTeamCodeFromTeamName(teamRequest.getTeamName()));
        RankingRequestResponse rankingRequestResponse = teamRequest.getRankingRequestResponse();
        if (team.getRankingId() == null) {
            Ranking ranking = RankingConverter.convertRankingRequestResponseToRanking(team.getId(), rankingRequestResponse);
            Ranking rankingSaved = rankingRepository.save(ranking);
            team.setRankingId(rankingSaved.getId());
            teamRepository.save(team);
        } else {
            Ranking rankingSaved = rankingRepository.findByTeamId(team.getId());
            RankingConverter.updateRankingFromRankingRequestResponse(rankingSaved, rankingRequestResponse);
            rankingRepository.save(rankingSaved);
        }
    }

    @Override
    public void massUpdateRankings(TeamListRequest teamListRequest) {
        rankingRepository.deleteAll();
        List<Team> teamList = teamRepository.findAll();
        teamList.forEach(team -> team.setRankingId(null));
        Map<Long, Team> teamCodeToTeamMap = new HashMap<>();
        teamList.forEach(team -> teamCodeToTeamMap.put(team.getTeamCode(), team));

        Map<Long, Team> teamIdToTeamMap = new HashMap<>();
        teamList.forEach(team -> teamIdToTeamMap.put(team.getId(), team));

        List<Ranking> rankingList = new ArrayList<>();

        for (TeamRequest teamRequest : teamListRequest.getTeamRequests()) {
            Long teamCode = TeamEnum.getTeamCodeFromTeamName(teamRequest.getTeamName());
            Long teamId = teamCodeToTeamMap.get(teamCode).getId();
            RankingRequestResponse rankingRequestResponse = teamRequest.getRankingRequestResponse();
            Ranking ranking = RankingConverter.convertRankingRequestResponseToRanking(teamId, rankingRequestResponse);
            rankingList.add(ranking);
        }

        rankingRepository.saveAll(rankingList);
        List<Ranking> rankingsSaved = rankingRepository.findAll();

        rankingsSaved.forEach(ranking -> {
            teamIdToTeamMap.get(ranking.getTeamId()).setRankingId(ranking.getId());
        });
        teamRepository.saveAll(teamList);
    }

    @Override
    public RankingRequestResponse getRankingByTeamName(String teamName) {
        Ranking ranking = converters.getRankingFromTeamName(teamName);
        return RankingConverter.convertRankingToRankingRequestResponse(ranking);
    }

    @Override
    public Long getTestRankingForTeam(String teamName) {
        Ranking ranking = converters.getRankingFromTeamName(teamName);
        return ranking.getTestRanking();
    }

    @Override
    public Long getOdiRankingForTeam(String teamName) {
        Ranking ranking = converters.getRankingFromTeamName(teamName);
        return ranking.getOdiRanking();
    }

    @Override
    public Long getT20RankingForTeam(String teamName) {
        Ranking ranking = converters.getRankingFromTeamName(teamName);
        return ranking.getT20Ranking();
    }
}
