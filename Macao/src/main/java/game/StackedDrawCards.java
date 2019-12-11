package game;

import utils.constants.GameConstants;
import utils.enums.GameStatus;

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

        if (numberOfCards <= 1) {
            numberOfCards = 1;
        }

        IntStream.range(0, numberOfCards).mapToObj(card -> room.getDeck().getCard())
                .filter(Objects::nonNull).forEach(extracted -> target.getCards().add(extracted));
        clear();

        if (room.getDeck().getCards().isEmpty()) {
            room.calculateWinner();
            room.setStatus(GameStatus.FINISHED);
        }
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

    public int getNumberOfCards() {
        return numberOfCards;
    }
}
