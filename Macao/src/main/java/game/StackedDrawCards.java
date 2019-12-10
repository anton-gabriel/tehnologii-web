package game;

import utils.constants.GameConstants;

import java.util.Objects;
import java.util.stream.IntStream;

/**
 * The type Stacked draw cards.
 */
public class StackedDrawCards {
    private int numberOfCards;

    /**
     * Instantiates a new Stacked draw cards.
     */
    public StackedDrawCards() {
        this.numberOfCards = GameConstants.INITIAL_STACKED_CARDS;
    }

    /**
     * Draw.
     *
     * @param room the room
     */
    public void draw(GameRoom room) {
        Player target = room.getPlayers().getCurrentPlayer();
        IntStream.range(0, numberOfCards).mapToObj(card -> room.getDeck().getCard())
                .filter(Objects::nonNull).forEach(extracted -> target.getCards().add(extracted));
        clear();
    }

    /**
     * Clear the stacked cards.
     *
     * @return the boolean
     */
    public boolean clear() {
        this.numberOfCards = GameConstants.INITIAL_STACKED_CARDS;
        return true;
    }

    /**
     * Add cards.
     *
     * @param cards the card number
     * @return the boolean
     */
    public boolean addCards(int cards) {
        this.numberOfCards += cards;
        return true;
    }

    /**
     * Is empty.
     *
     * @return whether there are stacked cards to draw
     */
    public boolean isEmpty() {
        return this.numberOfCards == GameConstants.INITIAL_STACKED_CARDS;
    }
}
