package utils;

import game.GameRoom;

import java.util.ArrayList;
import java.util.UUID;

/**
 * The type Global info.
 */
public class GlobalInfo {
    /**
     * The constant games.
     */
    public static ArrayList<GameRoom> games = new ArrayList<GameRoom>();

    /**
     * Gets game.
     *
     * @param id the id
     * @return the game
     */
    public static GameRoom getGame(UUID id) {
        for (GameRoom game : games) {
            if (game.getId().equals(id)) {
                return game;
            }
        }
        return null;
    }
}
