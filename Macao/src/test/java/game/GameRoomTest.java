package game;

import model.User;
import org.junit.jupiter.api.Test;
import utils.collections.PlayerList;
import utils.constants.GameConstants;
import utils.enums.CardNumber;
import utils.enums.CardSymbol;
import utils.enums.GameStatus;

import java.util.ArrayList;
import java.util.UUID;

/**
 * The type Game room test.
 */
class GameRoomTest {

    private Player player = new Player(new User.UserBuilder("Gabi").build());

    /**
     * Start game test method.
     */
    @Test
    void startGame() {
        GameRoom gameRoom = new GameRoom(player);
        assert !gameRoom.startGame();
    }

    /**
     * Add player test method.
     */
    @Test
    void addPlayer() {
        GameRoom gameRoom = new GameRoom(player);
        gameRoom.addPlayer(new Player(new User.UserBuilder("Cristi").build()));
        assert gameRoom.getPlayers().size() == GameConstants.MINIMUM_PLAYERS;
    }

    /**
     * Gets players test method.
     */
    @Test
    void getPlayers() {
        GameRoom gameRoom = new GameRoom(player);
        assert gameRoom.getPlayers() != null;
    }

    /**
     * Sets players test method.
     */
    @Test
    void setPlayers() {
        GameRoom gameRoom = new GameRoom(player);
        gameRoom.setPlayers(new PlayerList(player));
        assert gameRoom.getPlayers() != null;
    }

    /**
     * Gets deck test method.
     */
    @Test
    void getDeck() {
        GameRoom gameRoom = new GameRoom(player);
        assert gameRoom.getDeck() instanceof Deck;
    }

    /**
     * Sets deck test method.
     */
    @Test
    void setDeck() {
        GameRoom gameRoom = new GameRoom(player);
        Deck deck = new Deck();
        gameRoom.setDeck(deck);
        assert gameRoom.getDeck().equals(deck);
    }

    /**
     * Gets game owner test method.
     */
    @Test
    void getGameOwner() {
        GameRoom gameRoom = new GameRoom(player);
        assert gameRoom.getGameOwner().equals(player);
    }

    /**
     * Sets game owner test method.
     */
    @Test
    void setGameOwner() {
        GameRoom gameRoom = new GameRoom(player);
        Player player = new Player(new User.UserBuilder("Gabi").build());
        gameRoom.setGameOwner(player);
        assert gameRoom.getGameOwner().equals(player);
    }

    /**
     * Gets current card test method.
     */
    @Test
    void getCurrentCard() {
        GameRoom gameRoom = new GameRoom(player);
        StandardCard card = new StandardCard(CardNumber.ACE, CardSymbol.CLUBS);
        gameRoom.setCurrentCard(card);
        assert gameRoom.getCurrentCard().equals(card);
    }

    /**
     * Sets current card test method.
     */
    @Test
    void setCurrentCard() {
        GameRoom gameRoom = new GameRoom(player);
        StandardCard card = new StandardCard(CardNumber.ACE, CardSymbol.CLUBS);
        gameRoom.setCurrentCard(card);
        assert gameRoom.getCurrentCard().equals(card);
    }

    /**
     * Gets stacked draw cards test method.
     */
    @Test
    void getStackedDrawCards() {
        GameRoom gameRoom = new GameRoom(player);
        gameRoom.setStackedDrawCards(new StackedDrawCards());
        assert gameRoom.getStackedDrawCards() != null;
    }

    /**
     * Sets stacked draw cards test method.
     */
    @Test
    void setStackedDrawCards() {
        GameRoom gameRoom = new GameRoom(player);
        StackedDrawCards stackedDrawCards = new StackedDrawCards();
        gameRoom.setStackedDrawCards(stackedDrawCards);
        assert gameRoom.getStackedDrawCards().equals(stackedDrawCards);
    }

    /**
     * Gets id test method.
     */
    @Test
    void getId() {
        GameRoom gameRoom = new GameRoom(player);
        assert gameRoom.getId() != null;
    }

    /**
     * Sets id test method.
     */
    @Test
    void setId() {
        GameRoom gameRoom = new GameRoom(player);
        UUID uuid = UUID.randomUUID();
        gameRoom.setId(uuid);
        assert gameRoom.getId().equals(uuid);
    }

    /**
     * Gets spectators test method.
     */
    @Test
    void getSpectators() {
        GameRoom gameRoom = new GameRoom(player);
        gameRoom.setSpectators(new ArrayList<>());
        assert gameRoom.getSpectators() != null;
    }

    /**
     * Sets spectators test method.
     */
    @Test
    void setSpectators() {
        GameRoom gameRoom = new GameRoom(player);
        ArrayList<Player> spectators = new ArrayList<>();
        spectators.add(new Player(new User.UserBuilder("Spectator").build()));
        gameRoom.setSpectators(spectators);
        assert gameRoom.getSpectators().equals(spectators);
    }

    /**
     * Gets status test method.
     */
    @Test
    void getStatus() {
        GameRoom gameRoom = new GameRoom(player);
        assert gameRoom.getStatus() == GameStatus.INACTIVE;
    }

    /**
     * Sets status test method.
     */
    @Test
    void setStatus() {
        GameRoom gameRoom = new GameRoom(player);
        gameRoom.setStatus(GameStatus.ACTIVE);
        assert gameRoom.getStatus() == GameStatus.ACTIVE;
    }

    /**
     * Test equals test method.
     */
    @Test
    void testEquals() {
        GameRoom firstRoom = new GameRoom(player);
        GameRoom secondRoom = new GameRoom(player);
        assert !firstRoom.equals(secondRoom);
    }

    /**
     * Test hash code test method.
     */
    @Test
    void testHashCode() {
        GameRoom firstRoom = new GameRoom(player);
        GameRoom secondRoom = new GameRoom(player);
        assert firstRoom.hashCode() != secondRoom.hashCode();
    }
}