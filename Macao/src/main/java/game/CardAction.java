package game;

import utils.constants.CardsValues;
import utils.enums.CardColor;
import utils.enums.CardNumber;
import utils.enums.CardSymbol;
import validators.CardValidator;

import java.util.function.BiFunction;
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
    public static BiFunction<Card, GameRoom, Boolean> getAction(Card card, GameRoom room) {
        if (card instanceof StandardCard) {
            return getStandardCardAction((StandardCard) card, room);
        } else if (card instanceof JokerCard) {
            return getJokerAction((JokerCard) card, room);
        }
        return (gameCard, game) -> applyInvalidAction();
    }

    private static BiFunction<Card, GameRoom, Boolean> getStandardCardAction(StandardCard card, GameRoom room) {
        switch (card.getCardNumber()) {
            case TWO:
            case THREE:
                return (gameCard, game) -> applyDrawAction(card, room);
            case FOUR:
                return (gameCard, game) -> applyStopAction(card, room);
            case SEVEN:
                return (gameCard, game) -> applyChangeCardAction(card, room);
            default:
                if (CardValidator.isCardValid(card, room)) {
                    return (gameCard, game) -> applyStandardAction(card, room);
                }
        }
        return (gameCard, game) -> applyInvalidAction();
    }

    private static BiFunction<Card, GameRoom, Boolean> getJokerAction(JokerCard card, GameRoom room) {
        switch (card.getCardColor()) {
            case BLACK:
            case RED:
                if (CardValidator.isJokerValid(card, room)) {
                    return (gameCard, game) -> applyJokerAction(card, room);

                }
        }
        return (gameCard, game) -> applyInvalidAction();
    }

    private static Boolean applyStandardAction(StandardCard card, GameRoom room) {
        return removeCard(card, room);
    }

    private static Boolean applyDrawAction(StandardCard card, GameRoom room) {
        return room.getStackedDrawCards().addCards(card.getCardNumber().getValue()) ? removeCard(card, room) : Boolean.valueOf(false);
    }

    private static Boolean applyStopAction(StandardCard card, GameRoom room) {
        return room.getStackedDrawCards().clear() ? removeCard(card, room) : Boolean.valueOf(false);
    }

    private static Boolean applyJokerAction(JokerCard card, GameRoom room) {
        CardColor color = card.getCardColor();
        if (color.equals(CardColor.BLACK)) {
            room.getStackedDrawCards().addCards(CardsValues.BLACK_JOKER);
            return removeCard(card, room);
        } else if (color.equals(CardColor.RED)) {
            room.getStackedDrawCards().addCards(CardsValues.RED_JOKER);
            return removeCard(card, room);
        }
        return false;
    }

    private static Boolean applyChangeCardAction(StandardCard card, GameRoom room) {
        CardSymbol symbol = room.getPlayers().getCurrentPlayer().getDesiredCardSymbol();
        room.setCurrentCard(new StandardCard(CardNumber.SEVEN, symbol));
        return removeCard(card, room);
    }

    private static Boolean applyInvalidAction() {
        return false;
    }

    private static Boolean removeCard(Card card, GameRoom room) {
        if (room.getPlayers().getCurrentPlayer().getCards().remove(card)) {
            room.setCurrentCard(card);
            return true;
        }
        return false;
    }
}
