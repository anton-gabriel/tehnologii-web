package utils;

import game.GameRoom;
import game.Player;
import model.User;
import org.junit.jupiter.api.Test;

/**
 * The type Global info test.
 */
class GlobalInfoTest {

    /**
     * Gets game.
     */
    @Test
    void getGame() {
        Player player = new Player(new User.UserBuilder("Gabi").build());
        GameRoom gameRoom = new GameRoom(player);
        GlobalInfo.games.add(gameRoom);
        assert GlobalInfo.getGame(gameRoom.getId()).equals(gameRoom);
    }
}