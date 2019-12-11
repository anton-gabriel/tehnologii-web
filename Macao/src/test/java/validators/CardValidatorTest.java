package validators;

import game.GameRoom;
import game.JokerCard;
import game.Player;
import game.StandardCard;
import model.User;
import org.junit.jupiter.api.Test;
import utils.enums.CardColor;
import utils.enums.CardNumber;
import utils.enums.CardSymbol;

import static org.junit.jupiter.api.Assertions.*;

class CardValidatorTest {

    @Test
    void isCardValid() {
        Player player = new Player(new User.UserBuilder("Gabi").build());
        GameRoom gameRoom = new GameRoom(player);
        gameRoom.setCurrentCard(new JokerCard(CardColor.BLACK));
        StandardCard standardCard = new StandardCard(CardNumber.ACE, CardSymbol.CLUBS);
        assert CardValidator.isCardValid(standardCard, gameRoom);
    }

    @Test
    void isNotCardValid() {
        Player player = new Player(new User.UserBuilder("Gabi").build());
        GameRoom gameRoom = new GameRoom(player);
        gameRoom.setCurrentCard(new StandardCard(CardNumber.ACE, CardSymbol.HEARTS));
        StandardCard standardCard = new StandardCard(CardNumber.TEN, CardSymbol.CLUBS);
        assert !CardValidator.isCardValid(standardCard, gameRoom);
    }

    @Test
    void isJokerValid() {
        Player player = new Player(new User.UserBuilder("Gabi").build());
        GameRoom gameRoom = new GameRoom(player);
        gameRoom.setCurrentCard(new JokerCard(CardColor.BLACK));
        JokerCard jokerCard = new JokerCard(CardColor.RED);
        assert CardValidator.isJokerValid(jokerCard, gameRoom);
    }

    @Test
    void isNotJokerValid() {
        Player player = new Player(new User.UserBuilder("Gabi").build());
        GameRoom gameRoom = new GameRoom(player);
        gameRoom.setCurrentCard(new StandardCard(CardNumber.ACE, CardSymbol.CLUBS));
        JokerCard jokerCard = new JokerCard(CardColor.RED);
        assert !CardValidator.isJokerValid(jokerCard, gameRoom);
    }
}