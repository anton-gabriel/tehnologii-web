package repository;

import model.User;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

/**
 * The type User repository test.
 */
class UserRepositoryTest {

    /**
     * Login.
     *
     * @throws SQLException the sql exception
     */
    @Test
    void login() throws SQLException {
        UserRepository userRepository = new UserRepository();
        User user = new User.UserBuilder("Gabi").setPassword("test").build();
        assert !userRepository.login(user).equals(user);
    }

    /**
     * Register.
     *
     * @throws SQLException the sql exception
     */
    @Test
    void register() {
        UserRepository userRepository = new UserRepository();
        User user = new User.UserBuilder("Gabi").setPassword("test").build();
        try {
            assert !userRepository.register(user).equals(user);
        }
        catch (SQLException exception) {
            assert true;
        }
    }
}