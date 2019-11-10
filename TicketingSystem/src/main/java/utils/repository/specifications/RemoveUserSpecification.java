package utils.repository.specifications;

import database.DatabaseConnection;
import model.User;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RemoveUserSpecification extends SqlSpecification<User> {

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
