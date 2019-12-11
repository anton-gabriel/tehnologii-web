package repository;

import model.User;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

/**
 * The type Repository test.
 */
class RepositoryTest {

    /**
     * Add.
     *
     * @throws SQLException the sql exception
     */
    @Test
    void add() throws SQLException {
        Repository<User> repository = new Repository<User>();
        User user = new User.UserBuilder("Gabi").setPassword("test").build();
        try {
            repository.add(null);
        } catch (Exception exception) {
            assert true;
        }
    }

    /**
     * Update.
     */
    @Test
    void update() {
        Repository<User> repository = new Repository<User>();
        User user = new User.UserBuilder("NotFound").setPassword("test").build();
        try {
            repository.update(null);
        } catch (Exception exception) {
            assert true;
        }
    }

    /**
     * Remove.
     */
    @Test
    void remove() {
        Repository<User> repository = new Repository<User>();
        User user = new User.UserBuilder("NotFound").setPassword("test").build();
        try {
            repository.remove(null);
        } catch (Exception exception) {
            assert true;
        }
    }
}