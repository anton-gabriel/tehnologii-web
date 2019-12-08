package utils.collections;

import game.Player;

import java.util.ArrayList;

public class PlayerList extends ArrayList<Player> {

    private int currentPlayer;

    public PlayerList(Player owner) {
        super();
        super.add(owner);
        this.currentPlayer = super.indexOf(owner);
    }

    public Player getNextPlayer() {
        this.currentPlayer = (this.currentPlayer + 1) % super.size();
        return super.get(this.currentPlayer);
    }
}
