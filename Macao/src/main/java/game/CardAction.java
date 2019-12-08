package game;

import validators.CardValidator;

import java.util.function.Function;

public class CardAction {

    public static Function<GameRoom, Boolean> getAction(Card card, GameRoom room) {
        if (card instanceof StandardCard) {
            return getStandardCardAction((StandardCard) card, room);
        } else if (card instanceof JokerCard) {
            return getJokerAction((JokerCard) card, room);
        } else {
            return null;
        }
    }

    private static Function<GameRoom, Boolean> getStandardCardAction(StandardCard card, GameRoom room) {
        switch (card.getCardNumber()) {
            case TWO:
            case THREE:

            case FOUR:

            default:
                if (CardValidator.isCardValid(card, room)) {
                    return gameRoom -> applyStandardAction(card, room);
                }

        }
        return null;
    }

    private static Function<GameRoom, Boolean> getJokerAction(JokerCard card, GameRoom room) {
        switch (card.getCardColor()) {
            case BLACK:
                break;
            case RED:
                break;
        }
        return null;
    }

    private static Boolean applyStandardAction(StandardCard card, GameRoom room) {
        if (room.getPlayers().getCurrentPlayer().getCards().remove(card)) {
            room.setCurrentCard(card);
            return true;
        }
        return false;
    }

    private  static  Boolean applyDrawAction(StandardCard card, GameRoom room) {
        return false;
    }

}
