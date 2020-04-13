package cricket.tournament.simulation.enums;

import lombok.Getter;

@Getter
public enum TeamEnum {
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

    TeamEnum(Long teamCode, String teamName) {
        this.teamCode = teamCode;
        this.teamName = teamName;
    }

    public static TeamEnum getValue(String teamName) {
        for (TeamEnum teamEnum : TeamEnum.values()) {
            if (teamEnum.teamName.equalsIgnoreCase(teamName)) {
                return teamEnum;
            }
        }
        return null;
    }

    public static TeamEnum getValue(Long teamCode) {
        for (TeamEnum teamEnum : TeamEnum.values()) {
            if (teamEnum.teamCode.equals(teamCode)) {
                return teamEnum;
            }
        }
        return null;
    }

    public static Long getTeamCodeFromTeamName(String teamName){
        for (TeamEnum teamEnum : TeamEnum.values()) {
            if (teamEnum.teamName.equals(teamName)) {
                return teamEnum.teamCode;
            }
        }
        return null;
    }

    public static String getTeamNameFromTeamCode(Long teamCode){
        for (TeamEnum teamEnum : TeamEnum.values()) {
            if (teamEnum.teamCode.equals(teamCode)) {
                return teamEnum.teamName;
            }
        }
        return null;
    }
}
