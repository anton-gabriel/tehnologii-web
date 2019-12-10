package utils.enums;

import utils.constants.GameConstants;

public enum GameStatus {
    INACTIVE(GameConstants.GAME_STATUS_INACTIVE),
    ACTIVE(GameConstants.GAME_STATUS_ACTIVE),
    FINISHED(GameConstants.GAME_STATUS_FINISHED);

    private int value;

    GameStatus(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
