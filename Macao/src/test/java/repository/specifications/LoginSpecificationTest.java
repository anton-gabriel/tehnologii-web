package repository.specifications;

import model.User;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

/**
 * The type Login specification test.
 */
class LoginSpecificationTest {

    /**
     * Gets specification.
     *
     * @throws SQLException the sql exception
     */
    @Test
    void getSpecification() throws SQLException {
        User user = new User.UserBuilder("Gabi").setPassword("test").build();
        LoginSpecification addUserSpecification = new LoginSpecification(user);
        assert addUserSpecification.getSpecification() != null;
    }
}