package game;

import model.User;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utils.collections.CardsHand;
import utils.enums.CardColor;
import utils.enums.CardNumber;
import utils.enums.CardSymbol;

/**
 * The type Card action test.
 */
class CardActionTest {

    private static GameRoom gameRoom;
    private static Player player;

    /**
     * Before all.
     */
    @BeforeAll
    static void beforeAll() {
        player = new Player(new User.UserBuilder("Gabi").build());
        gameRoom = new GameRoom(player);
        gameRoom.getDeck();
    }

    /**
     * Sets up.
     */
    @BeforeEach
    void setUp() {
        CardsHand cards = new CardsHand();
        player.setCards(cards);
    }

    /**
     * Gets action standard card test method.
     */
    @Test
    void getActionStandardCard() {
        Card selected = gameRoom.getDeck().getCards().stream().filter(card -> {
            if (card instanceof StandardCard) {
                return ((StandardCard) card).getCardNumber().equals(CardNumber.ACE);
            }
            return false;
        }).findFirst().get();
        player.getCards().add(selected);
        gameRoom.setCurrentCard(selected);
        if (gameRoom.getStackedDrawCards().isEmpty()) {
            assert CardAction.getAction(selected, gameRoom).apply(selected, gameRoom);
        }
        assert !CardAction.getAction(selected, gameRoom).apply(selected, gameRoom);
    }


    /**
     * Gets action draw card test method.
     */
    @Test
    void getActionDrawCard() {
        Card selected = gameRoom.getDeck().getCards().stream().filter(card -> {
            if (card instanceof StandardCard) {
                return ((StandardCard) card).getCardNumber().equals(CardNumber.THREE);
            }
            return false;
        }).findFirst().get();
        player.getCards().add(selected);
        gameRoom.setCurrentCard(selected);
        assert CardAction.getAction(selected, gameRoom).apply(selected, gameRoom);
    }

    /**
     * Gets action change card test method.
     */
    @Test
    void getActionChangeCard() {
        Card selected = gameRoom.getDeck().getCards().stream().filter(card -> {
            if (card instanceof StandardCard) {
                return ((StandardCard) card).getCardNumber().equals(CardNumber.SEVEN);
            }
            return false;
        }).findFirst().get();
        player.setDesiredCardSymbol(CardSymbol.CLUBS);
        player.getCards().add(selected);
        gameRoom.setCurrentCard(selected);
        assert CardAction.getAction(selected, gameRoom).apply(selected, gameRoom);
    }

    /**
     * Gets action stop card test method.
     */
    @Test
    void getActionStopCard() {
        Card selected = gameRoom.getDeck().getCards().stream().filter(card -> {
            if (card instanceof StandardCard) {
                return ((StandardCard) card).getCardNumber().equals(CardNumber.FOUR);
            }
            return false;
        }).findFirst().get();
        player.getCards().add(selected);
        gameRoom.setCurrentCard(selected);
        assert CardAction.getAction(selected, gameRoom).apply(selected, gameRoom);
    }

    /**
     * Gets action joker black card test method.
     */
    @Test
    void getActionJokerBlackCard() {
        Card selected = gameRoom.getDeck().getCards().stream().filter(card -> {
            if (card instanceof JokerCard) {
                return ((JokerCard) card).getCardColor().equals(CardColor.BLACK);
            }
            return false;
        }).findFirst().get();
        gameRoom.setCurrentCard(selected);
        player.getCards().add(selected);
        assert CardAction.getAction(selected, gameRoom).apply(selected, gameRoom);
    }

    /**
     * Gets action joker red card test method.
     */
    @Test
    void getActionJokerRedCard() {
        Card selected = gameRoom.getDeck().getCards().stream().filter(card -> {
            if (card instanceof JokerCard) {
                return ((JokerCard) card).getCardColor().equals(CardColor.RED);
            }
            return false;
        }).findFirst().get();
        gameRoom.setCurrentCard(selected);
        player.getCards().add(selected);
        assert CardAction.getAction(selected, gameRoom).apply(selected, gameRoom);
    }

    /**
     * Gets action invalid card test method.
     */
    @Test
    void getActionInvalidCard() {
        Card selected = gameRoom.getDeck().getCards().stream().filter(card -> {
            if (card instanceof JokerCard) {
                return ((JokerCard) card).getCardColor().equals(CardColor.RED);
            }
            return false;
        }).findFirst().get();
        ((JokerCard) selected).setCardColor(null);
        gameRoom.setCurrentCard(selected);
        player.getCards().add(selected);
        assert !CardAction.getAction(selected, gameRoom).apply(selected, gameRoom);
    }
}