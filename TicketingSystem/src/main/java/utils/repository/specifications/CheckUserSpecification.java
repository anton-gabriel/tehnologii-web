package utils.repository.specifications;

import database.DatabaseConnection;
import model.User;

import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * The type Check user specification.
 */
public class CheckUserSpecification extends SqlSpecification<User> {

    /**
     * Instantiates a new Check user specification.
     *
     * @param entity the entity
     */
    public CheckUserSpecification(User entity) {
        super(entity);
    }

    @Override
    public PreparedStatement getSpecification() throws SQLException {
        PreparedStatement statement = DatabaseConnection.getInstance().getConnection()
                .prepareStatement("SELECT id, username, type FROM user_account WHERE username = ?");
        statement.setString(1, this.entity.getUsername().trim());
        return statement;
    }
}
