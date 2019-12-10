package game;

import model.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utils.collections.CardsHand;
import utils.constants.GameConstants;
import utils.enums.PlayerStatus;

/**
 * The type Player test.
 */
class PlayerTest {

    private Player player;
    private Deck deck;

    /**
     * Sets up the data for test.
     */
    @BeforeEach
    void setUp() {
        User user = new User.UserBuilder("Gabi").build();
        this.player = new Player(user);
        this.deck = new Deck();
    }

    /**
     * Tear down.
     */
    @AfterEach
    void tearDown() {
    }

    /**
     * Take card test method.
     */
    @Test
    void takeCard() {
        player.takeCard(deck);
        assert !player.getCards().isEmpty();
    }

    /**
     * Gets user test method.
     */
    @Test
    void getUser() {
        assert this.player.getUser() != null;
    }

    /**
     * Sets user test method.
     */
    @Test
    void setUser() {
        this.player.setUser(new User.UserBuilder("Gabi").build());
        assert this.player.getUser() != null;
    }

    /**
     * Gets status test method.
     */
    @Test
    void getStatus() {
        PlayerStatus status = PlayerStatus.ACTIVE;
        this.player.setStatus(status);
        assert this.player.getStatus().equals(status);
    }

    /**
     * Sets status test method.
     */
    @Test
    void setStatus() {
        PlayerStatus status = PlayerStatus.ACTIVE;
        this.player.setStatus(status);
        assert this.player.getStatus().equals(status);
    }

    /**
     * Gets number of wins test method.
     */
    @Test
    void getNumberOfWins() {
        int numberOfWins = 1;
        this.player.setNumberOfWins(numberOfWins);
        assert this.player.getNumberOfWins() == numberOfWins;
    }

    /**
     * Sets number of wins test method.
     */
    @Test
    void setNumberOfWins() {
        int numberOfWins = 1;
        this.player.setNumberOfWins(numberOfWins);
        assert this.player.getNumberOfWins() == numberOfWins;
    }

    /**
     * Gets cards test method.
     */
    @Test
    void getCards() {
        CardsHand cardsHand = new CardsHand();
        assert this.player.getCards() != null;
    }

    /**
     * Sets cards test method.
     */
    @Test
    void setCards() {
        CardsHand cardsHand = new CardsHand();
        this.player.setCards(cardsHand);
        assert this.player.getCards().equals(cardsHand);
    }

    /**
     * Test equals test method.
     */
    @Test
    void testEquals() {
        Player firstPlayer = new Player(new User.UserBuilder("First").build());
        Player secondPlayer = new Player(new User.UserBuilder("Second").build());
        assert !firstPlayer.equals(secondPlayer);
    }

    /**
     * Test hash code test method.
     */
    @Test
    void testHashCode() {
        Player firstPlayer = new Player(new User.UserBuilder("First").build());
        Player secondPlayer = new Player(new User.UserBuilder("Second").build());
        assert !(firstPlayer.hashCode() == secondPlayer.hashCode());
    }

    /**
     * Test take card.
     */
    @Test
    void testTakeCard() {
        Deck deck = new Deck();
        player.takeCard(deck);
        assert !player.getCards().isEmpty();
    }

    /**
     * Test play card.
     */
    @Test
    void testPlayCard() {
        Deck deck = new Deck();
        player.takeCard(deck);
        assert !player.playCard(player.getCards().size() - 1);
    }

    /**
     * Test get user.
     */
    @Test
    void testGetUser() {
        assert player.getUser() != null;
    }

    /**
     * Test set user.
     */
    @Test
    void testSetUser() {
        User user = new User.UserBuilder("Test").build();
        player.setUser(user);
        assert player.getUser().equals(user);
    }

    /**
     * Test get status.
     */
    @Test
    void testGetStatus() {
        player.setStatus(PlayerStatus.ACTIVE);
        assert player.getStatus() == PlayerStatus.ACTIVE;
    }

    /**
     * Test set status.
     */
    @Test
    void testSetStatus() {
        player.setStatus(PlayerStatus.ACTIVE);
        assert player.getStatus() == PlayerStatus.ACTIVE;
    }

    /**
     * Test get number of wins.
     */
    @Test
    void testGetNumberOfWins() {
        player.setNumberOfWins(GameConstants.INITIAL_PLAYER_WINS);
        assert player.getNumberOfWins() == GameConstants.INITIAL_PLAYER_WINS;
    }

    /**
     * Test set number of wins.
     */
    @Test
    void testSetNumberOfWins() {
        player.setNumberOfWins(GameConstants.INITIAL_PLAYER_WINS);
        assert player.getNumberOfWins() == GameConstants.INITIAL_PLAYER_WINS;
    }

}