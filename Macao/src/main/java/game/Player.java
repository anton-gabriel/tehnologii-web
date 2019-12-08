package game;

import model.User;
import utils.collections.CardsHand;
import utils.constants.GameConstants;
import utils.enums.PlayerStatus;

import java.util.Objects;

/**
 * The type Player.
 */
public class Player {

    private User user;
    private PlayerStatus status;
    private CardsHand cards;
    private int numberOfWins = GameConstants.INITIAL_PLAYER_WINS;

    /**
     * Instantiates a new Player.
     *
     * @param user the user
     */
    public Player(User user) {
        this.user = user;
        this.cards = new CardsHand();
        this.status = PlayerStatus.ATTENDING;
    }

    /**
     * Take a card from the deck.
     *
     * @param deck the deck
     * @return true if deck is not empty, false otherwise
     */
    public boolean takeCard(Deck deck) {
        Card card = deck.getCard();
        if (card != null) {
            this.cards.add(card);
            return true;
        }
        return false;
    }

    public boolean playCard(int index) {
        //1. Check if the card exists in player hand
        //2. Check if the card is "playable"
        //3. If it's "playable", apply its effect and return true,
        //return false, otherwise
        return false;
    }

    /**
     * Gets user.
     *
     * @return the user
     */
    public User getUser() {
        return user;
    }

    /**
     * Sets user.
     *
     * @param user the user
     */
    public void setUser(User user) {
        this.user = user;
    }

    /**
     * Gets status.
     *
     * @return the status
     */
    public PlayerStatus getStatus() {
        return status;
    }

    /**
     * Sets status.
     *
     * @param status the status
     */
    public void setStatus(PlayerStatus status) {
        this.status = status;
    }

    /**
     * Gets number of wins.
     *
     * @return the number of wins
     */
    public Integer getNumberOfWins() {
        return numberOfWins;
    }

    /**
     * Sets number of wins.
     *
     * @param numberOfWins the number of wins
     */
    public void setNumberOfWins(Integer numberOfWins) {
        this.numberOfWins = numberOfWins;
    }

    /**
     * Gets cards.
     *
     * @return the cards
     */
    public CardsHand getCards() {
        return cards;
    }

    /**
     * Sets cards.
     *
     * @param cards the cards
     */
    public void setCards(CardsHand cards) {
        this.cards = cards;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Player player = (Player) o;
        return numberOfWins == player.numberOfWins &&
                user.equals(player.user) &&
                status == player.status &&
                Objects.equals(cards, player.cards);
    }

    @Override
    public int hashCode() {
        return Objects.hash(user, status, cards, numberOfWins);
    }
}
