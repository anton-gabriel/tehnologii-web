package repository.specifications;

import model.User;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

/**
 * The type Add user specification test.
 */
class AddUserSpecificationTest {

    /**
     * Gets specification.
     *
     * @throws SQLException the sql exception
     */
    @Test
    void getSpecification() throws SQLException {
        User user = new User.UserBuilder("Gabi").setPassword("test").build();
        AddUserSpecification addUserSpecification = new AddUserSpecification(user);
        assert addUserSpecification.getSpecification() != null;
    }
}