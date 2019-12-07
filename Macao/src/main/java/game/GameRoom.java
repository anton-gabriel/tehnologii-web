package game;

import utils.collections.PlayerList;

/**
 * The type Game room.
 */
public class GameRoom {

    private PlayerList players;
    private Deck deck;
    private Player gameOwner;

    /**
     * Instantiates a new Game room.
     *
     * @param gameOwner the game owner
     */
    public GameRoom(Player gameOwner) {
        this.gameOwner = gameOwner;
        this.deck = new Deck();
        this.players = new PlayerList();
    }

    /**
     * Start the game.
     *
     * @return whether the game started
     */
    public boolean startGame() {
        //start the game if number of players is greater than MINIMUM_PLAYERS
        return false;
    }

    /**
     * Add a player to the game room.
     *
     * @param player the player
     * @return whether the player was added
     */
    public boolean addPlayer(Player player) {
        //add the player if the MAXIMUM_PLAYERS values is not reached
        return false;
    }

    /**
     * Gets players.
     *
     * @return the players
     */
    public PlayerList getPlayers() {
        return players;
    }

    /**
     * Sets players.
     *
     * @param players the players
     */
    public void setPlayers(PlayerList players) {
        this.players = players;
    }

    /**
     * Gets deck.
     *
     * @return the deck
     */
    public Deck getDeck() {
        return deck;
    }

    /**
     * Sets deck.
     *
     * @param deck the deck
     */
    public void setDeck(Deck deck) {
        this.deck = deck;
    }

    /**
     * Gets game owner.
     *
     * @return the game owner
     */
    public Player getGameOwner() {
        return gameOwner;
    }

    /**
     * Sets game owner.
     *
     * @param gameOwner the game owner
     */
    public void setGameOwner(Player gameOwner) {
        this.gameOwner = gameOwner;
    }
}
