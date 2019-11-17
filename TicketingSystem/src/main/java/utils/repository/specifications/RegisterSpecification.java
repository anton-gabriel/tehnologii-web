package utils.repository.specifications;

import model.User;

import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * The type Register specification.
 */
public class RegisterSpecification extends SqlSpecification<User> {

    /**
     * Instantiates a new Register specification.
     *
     * @param entity the entity
     */
    public RegisterSpecification(User entity) {
        super(entity);
    }

    @Override
    public PreparedStatement getSpecification() throws SQLException {
        AddUserSpecification addUserSpecification = new AddUserSpecification(this.entity);
        return addUserSpecification.getSpecification();
    }
}

