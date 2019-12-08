package validators;

import game.GameRoom;
import game.JokerCard;
import game.StandardCard;

/**
 * The type Card validator.
 */
public class CardValidator {

    /**
     * Is card valid.
     *
     * @param card the card
     * @param room the room
     * @return whether the card is valid to be played
     */
    public static boolean isCardValid(StandardCard card, GameRoom room) {
        if (!(room.getCurrentCard() instanceof StandardCard)) {
            return false;
        }
        StandardCard roomCard = (StandardCard) room.getCurrentCard();
        if (roomCard.getCardNumber().equals(card.getCardNumber())) {
            return true;
        }
        return roomCard.getCardSymbol().equals(card.getCardSymbol());
    }

    /**
     * Is joker valid.
     *
     * @param card the card
     * @param room the room
     * @return whether the card is valid to be played
     */
    public static boolean isJokerValid(JokerCard card, GameRoom room) {
        if (room.getCurrentCard() instanceof JokerCard) {
            return true;
        } else if (room.getCurrentCard() instanceof StandardCard) {
            StandardCard roomCard = (StandardCard) room.getCurrentCard();
            if (roomCard.getCardSymbol().getColor().equals(card.getCardColor())) {
                return true;
            }
        }
        return false;
    }
}
