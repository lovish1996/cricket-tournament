package cricket.tournament.simulation.enums;

import lombok.Getter;

@Getter
public enum Team {
    AFGHANISTAN(1L, "Afghanistan"),
    AUSTRALIA(2L, "Australia"),
    BANGLADESH(3L, "Bangladesh"),
    ENGLAND(4L, "England"),
    INDIA(5L, "India"),
    IRELAND(6L, "Ireland"),
    NEWZEALAND(7L, "New Zealand"),
    PAKISTAN(8L, "Pakistan"),
    SOUTHAFRICA(9L, "South Africa"),
    SRILANKA(10L, "Sri Lanka"),
    WESTINDIES(11L, "West Indies"),
    ZIMBAWBE(12L, "Zimbawbe");

    private Long teamCode;
    private String teamName;

    Team(Long teamCode, String teamName) {
        this.teamCode = teamCode;
        this.teamName = teamName;
    }

    public static Team getValue(String teamName) {
        for (Team team : Team.values()) {
            if (team.teamName.equalsIgnoreCase(teamName)) {
                return team;
            }
        }
        return null;
    }

    public static Team getValue(Long teamCode) {
        for (Team team : Team.values()) {
            if (team.teamCode.equals(teamCode)) {
                return team;
            }
        }
        return null;
    }

}
