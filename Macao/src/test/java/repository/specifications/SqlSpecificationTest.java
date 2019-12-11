package repository.specifications;

import model.User;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

/**
 * The type Sql specification test.
 */
class SqlSpecificationTest {

    /**
     * Gets specification.
     *
     * @throws SQLException the sql exception
     */
    @Test
    void getSpecification() throws SQLException {
        User user = new User.UserBuilder("Gabi").setPassword("test").build();
        RegisterSpecification addUserSpecification = new RegisterSpecification(user);
        assert addUserSpecification.getSpecification() != null;
    }
}