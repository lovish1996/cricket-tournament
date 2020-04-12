package cricket.tournament.simulation.enums;

import lombok.Getter;

@Getter
public enum Team {
    AFGHANISTAN("Afghanistan"),
    AUSTRALIA("Australia"),
    BANGLADESH("Bangladesh"),
    ENGLAND("England"),
    INDIA("India"),
    IRELAND("Ireland"),
    NEWZEALAND("New Zealand"),
    PAKISTAN("Pakistan"),
    SOUTHAFRICA("South Africa"),
    SRILANKA("Sri Lanka"),
    WESTINDIES("West Indies"),
    ZIMBAWBE("Zimbawbe");

    private String teamName;

    Team(String teamName){
        this.teamName = teamName;
    }
}
