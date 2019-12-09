package game;

import javafx.scene.paint.Color;
import utils.constants.CardsValues;
import utils.enums.CardColor;
import validators.CardValidator;

import java.util.function.Function;

/**
 * The type Card action.
 */
public final class CardAction {

    /**
     * Gets the specific action for a card.
     *
     * @param card the card
     * @param room the room
     * @return the action
     */
    public static Function<GameRoom, Boolean> getAction(Card card, GameRoom room) {
        if (card instanceof StandardCard) {
            return getStandardCardAction((StandardCard) card, room);
        } else if (card instanceof JokerCard) {
            return getJokerAction((JokerCard) card, room);
        }
        return gameRoom -> applyInvalidAction();
    }

    private static Function<GameRoom, Boolean> getStandardCardAction(StandardCard card, GameRoom room) {
        switch (card.getCardNumber()) {
            case TWO:
            case THREE:
                return gameRoom -> applyDrawAction(card, room);
            case FOUR:
                return gameRoom -> applyStopAction(card, room);
            case SEVEN:
                return gameRoom -> applyChangeCardAction(card, room);
            default:
                if (CardValidator.isCardValid(card, room)) {
                    return gameRoom -> applyStandardAction(card, room);
                }
        }
        return gameRoom -> applyInvalidAction();
    }

    private static Function<GameRoom, Boolean> getJokerAction(JokerCard card, GameRoom room) {
        switch (card.getCardColor()) {
            case BLACK:
            case RED:
                return gameRoom -> applyJokerAction(card, room);
        }
        return gameRoom -> applyInvalidAction();
    }

    private static Boolean applyStandardAction(StandardCard card, GameRoom room) {
        if (room.getPlayers().getCurrentPlayer().getCards().remove(card)) {
            room.setCurrentCard(card);
            return true;
        }
        return false;
    }

    private static Boolean applyDrawAction(StandardCard card, GameRoom room) {
        return room.getStackedDrawCards().addCards(card.getCardNumber().getValue());
    }

    private static Boolean applyStopAction(StandardCard card, GameRoom room) {
        return room.getStackedDrawCards().clear();
    }

    private static Boolean applyJokerAction(JokerCard card, GameRoom room) {
        CardColor color = card.getCardColor();
        if (color.equals(CardColor.BLACK)) {
            room.getStackedDrawCards().addCards(CardsValues.BLACK_JOKER);
            return true;
        } else if (color.equals(Color.RED)) {
            room.getStackedDrawCards().addCards(CardsValues.RED_JOKER);
            return true;
        }
        return false;
    }

    private static Boolean applyChangeCardAction(StandardCard card, GameRoom room) {
        room.setCurrentCard(card);
        return true;
    }

    private static Boolean applyInvalidAction() {
        return false;
    }
}
