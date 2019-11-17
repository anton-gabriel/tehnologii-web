package utils.repository.specifications;

import database.DatabaseConnection;
import model.User;

import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * The type Remove user specification.
 */
public class RemoveUserSpecification extends SqlSpecification<User> {

    /**
     * Instantiates a new Remove user specification.
     *
     * @param entity the entity
     */
    public RemoveUserSpecification(User entity) {
        super(entity);
    }

    @Override
    public PreparedStatement getSpecification() throws SQLException {
        PreparedStatement statement = DatabaseConnection.getInstance().getConnection()
                .prepareStatement("DELETE FROM user_account WHERE id = ?");
        statement.setInt(1, this.entity.getId());
        return statement;
    }
}
