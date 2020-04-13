package cricket.tournament.simulation.service.impl;

import cricket.tournament.simulation.repository.repository.TeamRepository;
import cricket.tournament.simulation.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeamServiceImpl implements TeamService {

    @Autowired
    TeamRepository teamRepository;

}
