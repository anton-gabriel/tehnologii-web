package game;

import model.User;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utils.collections.CardsHand;
import utils.enums.CardNumber;
import utils.enums.CardSymbol;

import java.util.function.BiFunction;
import java.util.function.Function;

class CardActionTest {

    private static GameRoom gameRoom;
    private static Player player;

    @BeforeAll
    static void beforeAll() {
        player = new Player(new User.UserBuilder("Gabi").build());
        gameRoom = new GameRoom(player);
        gameRoom.setCurrentCard(new StandardCard(CardNumber.ACE, CardSymbol.CLUBS));
        gameRoom.getDeck();
    }

    @BeforeEach
    void setUp() {
        CardsHand cards = new CardsHand();
        cards.add(gameRoom.getDeck().getCards().stream().filter(card -> card instanceof StandardCard).findFirst().get());
        cards.add(gameRoom.getDeck().getCards().stream().filter(card -> card instanceof JokerCard).findFirst().get());
        player.setCards(cards);
    }

    @Test
    void getAction() {
        Card selected = player.getCards().stream().filter(card -> card instanceof StandardCard).findFirst().get();
        BiFunction<Card, GameRoom, Boolean> action = CardAction.getAction(selected, gameRoom);
        assert action.apply(selected, gameRoom);
    }
}