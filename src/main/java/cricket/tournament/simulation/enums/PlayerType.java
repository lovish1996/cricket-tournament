package cricket.tournament.simulation.enums;

import lombok.Getter;

@Getter
public enum PlayerType {
    BATSMAN("Batsman"),
    BOWLER("Bowler"),
    ALLROUNDER("All Rounder");

    private String playerType;

    PlayerType(String playerType) {
        this.playerType = playerType;
    }

    public static PlayerType getValue(String playerType){

        for(PlayerType type: PlayerType.values()){
            if(type.playerType.equalsIgnoreCase(playerType)){
                return type;
            }
        }
        return null;
    }
}
