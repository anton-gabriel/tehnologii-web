package repository.specifications;

import database.DatabaseConnection;
import model.User;

import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * The type Add user specification.
 */
public class AddUserSpecification extends SqlSpecification<User> {

    /**
     * Instantiates a new Add user specification.
     *
     * @param entity the entity
     */
    public AddUserSpecification(User entity) {
        super(entity);
    }

    @Override
    public PreparedStatement getSpecification() throws SQLException {
        PreparedStatement statement = DatabaseConnection.getInstance().getConnection()
                .prepareStatement("INSERT INTO user_account(username, password) values (?,?)");
        statement.setString(1, this.entity.getUsername().trim());
        statement.setString(2, this.entity.getPassword().trim());
        return statement;
    }
}
