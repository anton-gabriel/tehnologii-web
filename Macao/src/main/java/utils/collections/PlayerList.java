package utils.collections;

import game.Player;

import java.util.ArrayList;

/**
 * The type Player list.
 */
public class PlayerList extends ArrayList<Player> {

    private int currentPlayer;

    /**
     * Instantiates a new Player list.
     *
     * @param owner the owner
     */
    public PlayerList(Player owner) {
        super();
        super.add(owner);
        this.currentPlayer = super.indexOf(owner);
    }

    public boolean remove(Player player) {
        Player nextPlayer = peekNextPlayer();
        if (super.remove(player)) {
            this.currentPlayer = super.indexOf(nextPlayer);
            return true;
        }
        return false;
    }

    /**
     * Gets current player.
     *
     * @return the current player
     */
    public Player getCurrentPlayer() {
        return super.get(this.currentPlayer);
    }

    /**
     * Peek next player.
     *
     * @return the player
     */
    public Player peekNextPlayer() {
        return super.get((this.currentPlayer + 1) % super.size());
    }

    /**
     * Gets next player.
     *
     * @return the next player
     */
    public Player getNextPlayer() {
        this.currentPlayer = (this.currentPlayer + 1) % super.size();
        return super.get(this.currentPlayer);
    }
}
