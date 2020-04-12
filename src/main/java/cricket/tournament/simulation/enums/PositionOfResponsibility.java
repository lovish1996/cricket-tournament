package cricket.tournament.simulation.enums;

import lombok.Getter;

@Getter
public enum PositionOfResponsibility {
    CAPTAIN("Captain"),
    VICECAPTAIN("Vice-Captain"),
    WICKETKEEPER("Wicket-Keeper");

    private String positionOfResponsibility;

    PositionOfResponsibility(String positionOfResponsibility) {
        this.positionOfResponsibility = positionOfResponsibility;
    }

    public static PositionOfResponsibility getValue(String positionOfResponsibility) {
        for (PositionOfResponsibility por : PositionOfResponsibility.values()) {
            if (por.positionOfResponsibility.equalsIgnoreCase(positionOfResponsibility)) {
                return por;
            }
        }
        return null;
    }
}
