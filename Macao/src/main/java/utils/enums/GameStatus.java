package utils.enums;

import utils.constants.GameConstants;

/**
 * The enum Game status.
 */
public enum GameStatus {

    /**
     * Inactive game status.
     */
    INACTIVE(GameConstants.GAME_STATUS_INACTIVE),
    /**
     * Active game status.
     */
    ACTIVE(GameConstants.GAME_STATUS_ACTIVE),
    /**
     * Finished game status.
     */
    FINISHED(GameConstants.GAME_STATUS_FINISHED);

    private int value;

    GameStatus(int value) {
        this.value = value;
    }

    /**
     * Gets value.
     *
     * @return the value
     */
    public int getValue() {
        return value;
    }

    /**
     * Sets value.
     *
     * @param value the value
     */
    public void setValue(int value) {
        this.value = value;
    }
}
