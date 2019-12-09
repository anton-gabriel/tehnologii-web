package game;

import utils.collections.PlayerList;
import utils.constants.GameConstants;

import java.util.Objects;
import java.util.UUID;
import java.util.logging.Logger;
import java.util.stream.IntStream;


/**
 * The type Game room.
 */
public class GameRoom {

    private UUID id;
    private PlayerList players;
    private Deck deck;
    private Player gameOwner;
    private Card currentCard;
    private StackedDrawCards stackedDrawCards;

    private Logger logger = Logger.getLogger(GameRoom.class.getName());

    /**
     * Instantiates a new Game room.
     *
     * @param gameOwner the game owner
     */
    public GameRoom(Player gameOwner) {
        this.id = UUID.randomUUID();
        this.gameOwner = gameOwner;
        this.deck = new Deck();
        this.players = new PlayerList(this.gameOwner);
        this.stackedDrawCards = new StackedDrawCards();
        this.logger.info(String.format("%s created with id = ", GameRoom.class.getName()));
    }

    /**
     * Start the game.
     *
     * @return whether the game started
     */
    public boolean startGame() {
        //start the game if number of players is greater than MINIMUM_PLAYERS
        if (this.players.size() >= GameConstants.MINIMUM_PLAYERS) {
            dealCards();
            //while game is not over, play players turns

            return true;
        }
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
        if (this.players.size() < GameConstants.MAXIMUM_PLAYERS) {
            this.players.add(player);
            return true;
        }
        return false;
    }

    private void dealCards() {
        for (Player player : players) {
            IntStream.range(0, GameConstants.START_CARDS).
                    forEach(card -> player.getCards().add(this.deck.getCard()));
        }
        this.currentCard = this.deck.getCard();
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

    /**
     * Gets current card.
     *
     * @return the current card
     */
    public Card getCurrentCard() {
        return currentCard;
    }

    /**
     * Sets current card.
     *
     * @param currentCard the current card
     */
    public void setCurrentCard(Card currentCard) {
        this.currentCard = currentCard;
    }

    /**
     * Gets stacked draw cards.
     *
     * @return the stacked draw cards
     */
    public StackedDrawCards getStackedDrawCards() {
        return stackedDrawCards;
    }

    /**
     * Sets stacked draw cards.
     *
     * @param stackedDrawCards the stacked draw cards
     */
    public void setStackedDrawCards(StackedDrawCards stackedDrawCards) {
        this.stackedDrawCards = stackedDrawCards;
    }

    /**
     * Gets id.
     *
     * @return the id
     */
    public UUID getId() {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(UUID id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        GameRoom gameRoom = (GameRoom) o;
        return id.equals(gameRoom.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
