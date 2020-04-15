package cricket.tournament.simulation.service.validation;

import cricket.tournament.simulation.api.dto.request.PlayerRequest;
import cricket.tournament.simulation.enums.PlayerType;
import cricket.tournament.simulation.enums.PositionOfResponsibility;
import cricket.tournament.simulation.enums.TeamEnum;
import org.springframework.stereotype.Component;

@Component
public class PlayerValidation {

    public static boolean validatePlayer(PlayerRequest playerRequest) {
        if (!validatePlayerType(playerRequest.getPlayerType())) {
            return false;
        }
        if (playerRequest.getPositionOfResponsibility() != null && !validatePositionOfResponsibility(playerRequest.getPositionOfResponsibility())) {
            return false;
        }

        return validateTeamName(playerRequest.getTeamName());
    }

    public static boolean validatePlayerType(String playerType) {
        for (PlayerType type : PlayerType.values()) {
            if (type.getPlayerType().equalsIgnoreCase(playerType)) {
                return true;
            }
        }
        return false;
    }

    public static boolean validatePositionOfResponsibility(String positionOfResponsibility) {
        for (PositionOfResponsibility responsibility : PositionOfResponsibility.values()) {
            if (responsibility.getPositionOfResponsibility().equalsIgnoreCase(positionOfResponsibility)) {
                return true;
            }
        }
        return false;
    }

    public static boolean validateTeamName(String teamName) {
        for (TeamEnum teamEnum : TeamEnum.values()) {
            if (teamEnum.getTeamName().equalsIgnoreCase(teamName)) {
                return true;
            }
        }
        return false;
    }
}
