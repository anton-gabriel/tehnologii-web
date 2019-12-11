package game;

import model.User;
import org.junit.jupiter.api.Test;
import utils.enums.CardNumber;

class StackedDrawCardsTest {

    @Test
    void draw() {
        StackedDrawCards stackedDrawCards = new StackedDrawCards();
        Player player = new Player(new User.UserBuilder("Gabi").build());
        GameRoom gameRoom = new GameRoom(player);
        stackedDrawCards.addCards(CardNumber.ACE.getValue());
        stackedDrawCards.draw(gameRoom);
        assert stackedDrawCards.isEmpty();
    }

    @Test
    void clear() {
        StackedDrawCards stackedDrawCards = new StackedDrawCards();
        Player player = new Player(new User.UserBuilder("Gabi").build());
        GameRoom gameRoom = new GameRoom(player);
        stackedDrawCards.addCards(CardNumber.ACE.getValue());
        stackedDrawCards.clear();
        assert stackedDrawCards.isEmpty();
    }

    @Test
    void addCards() {
        StackedDrawCards stackedDrawCards = new StackedDrawCards();
        stackedDrawCards.addCards(CardNumber.ACE.getValue());
        assert !stackedDrawCards.isEmpty();
    }

    @Test
    void isEmpty() {
        StackedDrawCards stackedDrawCards = new StackedDrawCards();
        assert stackedDrawCards.isEmpty();
    }

    @Test
    void getNumberOfCards() {
        StackedDrawCards stackedDrawCards = new StackedDrawCards();
        stackedDrawCards.addCards(CardNumber.ACE.getValue());
        assert stackedDrawCards.getNumberOfCards() == CardNumber.ACE.getValue();
    }

}