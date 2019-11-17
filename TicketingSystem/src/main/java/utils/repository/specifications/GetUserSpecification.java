package utils.repository.specifications;

import database.DatabaseConnection;
import model.User;

import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * The type Get user specification.
 */
public class GetUserSpecification extends  SqlSpecification<User> {

    /**
     * Instantiates a new Get user specification.
     *
     * @param entity the entity
     */
    public GetUserSpecification(User entity) {
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
