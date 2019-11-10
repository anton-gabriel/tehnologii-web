package utils.repository.specifications;

import database.DatabaseConnection;
import model.User;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateUserSpecification extends SqlSpecification<User> {

    public UpdateUserSpecification(User entity) {
        super(entity);
    }

    @Override
    public PreparedStatement getSpecification() throws SQLException {
        PreparedStatement statement = DatabaseConnection.getInstance().getConnection()
                .prepareStatement("UPDATE user_account SET username = ?, password = ?, type = ? WHERE id = ?");
        statement.setString(1, this.entity.getUsername());
        statement.setString(2, this.entity.getPassword());
        statement.setString(3, this.entity.getType());
        statement.setInt(4, this.entity.getId());
        return statement;
    }
}
