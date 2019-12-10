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

class GameRoomTest {

    private Player player = new Player(new User.UserBuilder("Gabi").build());

    @Test
    void startGame() {
        GameRoom gameRoom = new GameRoom(player);
        assert !gameRoom.startGame();
    }

    @Test
    void addPlayer() {
        GameRoom gameRoom = new GameRoom(player);
        gameRoom.addPlayer(new Player(new User.UserBuilder("Cristi").build()));
        assert gameRoom.getPlayers().size() == GameConstants.MINIMUM_PLAYERS;
    }

    @Test
    void getPlayers() {
        GameRoom gameRoom = new GameRoom(player);
        assert gameRoom.getPlayers() != null;
    }

    @Test
    void setPlayers() {
        GameRoom gameRoom = new GameRoom(player);
        gameRoom.setPlayers(new PlayerList(player));
        assert gameRoom.getPlayers() != null;
    }

    @Test
    void getDeck() {
        GameRoom gameRoom = new GameRoom(player);
        assert gameRoom.getDeck() instanceof Deck;
    }

    @Test
    void setDeck() {
        GameRoom gameRoom = new GameRoom(player);
        Deck deck = new Deck();
        gameRoom.setDeck(deck);
        assert gameRoom.getDeck().equals(deck);
    }

    @Test
    void getGameOwner() {
        GameRoom gameRoom = new GameRoom(player);
        assert gameRoom.getGameOwner().equals(player);
    }

    @Test
    void setGameOwner() {
        GameRoom gameRoom = new GameRoom(player);
        Player player = new Player(new User.UserBuilder("Gabi").build());
        gameRoom.setGameOwner(player);
        assert gameRoom.getGameOwner().equals(player);
    }

    @Test
    void getCurrentCard() {
        GameRoom gameRoom = new GameRoom(player);
        StandardCard card = new StandardCard(CardNumber.ACE, CardSymbol.CLUBS);
        gameRoom.setCurrentCard(card);
        assert gameRoom.getCurrentCard().equals(card);
    }

    @Test
    void setCurrentCard() {
        GameRoom gameRoom = new GameRoom(player);
        StandardCard card = new StandardCard(CardNumber.ACE, CardSymbol.CLUBS);
        gameRoom.setCurrentCard(card);
        assert gameRoom.getCurrentCard().equals(card);
    }

    @Test
    void getStackedDrawCards() {
        GameRoom gameRoom = new GameRoom(player);
        gameRoom.setStackedDrawCards(new StackedDrawCards());
        assert gameRoom.getStackedDrawCards() != null;
    }

    @Test
    void setStackedDrawCards() {
        GameRoom gameRoom = new GameRoom(player);
        StackedDrawCards stackedDrawCards = new StackedDrawCards();
        gameRoom.setStackedDrawCards(stackedDrawCards);
        assert gameRoom.getStackedDrawCards().equals(stackedDrawCards);
    }

    @Test
    void getId() {
        GameRoom gameRoom = new GameRoom(player);
        assert gameRoom.getId() != null;
    }

    @Test
    void setId() {
        GameRoom gameRoom = new GameRoom(player);
        UUID uuid = UUID.randomUUID();
        gameRoom.setId(uuid);
        assert gameRoom.getId().equals(uuid);
    }

    @Test
    void getSpectators() {
        GameRoom gameRoom = new GameRoom(player);
        gameRoom.setSpectators(new ArrayList<>());
        assert gameRoom.getSpectators() != null;
    }

    @Test
    void setSpectators() {
        GameRoom gameRoom = new GameRoom(player);
        ArrayList<Player> spectators = new ArrayList<>();
        spectators.add(new Player(new User.UserBuilder("Spectator").build()));
        gameRoom.setSpectators(spectators);
        assert gameRoom.getSpectators().equals(spectators);
    }

    @Test
    void getStatus() {
        GameRoom gameRoom = new GameRoom(player);
        assert gameRoom.getStatus() == GameStatus.INACTIVE;
    }

    @Test
    void setStatus() {
        GameRoom gameRoom = new GameRoom(player);
        gameRoom.setStatus(GameStatus.ACTIVE);
        assert gameRoom.getStatus() == GameStatus.ACTIVE;
    }

    @Test
    void testEquals() {
        GameRoom firstRoom = new GameRoom(player);
        GameRoom secondRoom = new GameRoom(player);
        assert !firstRoom.equals(secondRoom);
    }

    @Test
    void testHashCode() {
        GameRoom firstRoom = new GameRoom(player);
        GameRoom secondRoom = new GameRoom(player);
        assert firstRoom.hashCode() != secondRoom.hashCode();
    }
}