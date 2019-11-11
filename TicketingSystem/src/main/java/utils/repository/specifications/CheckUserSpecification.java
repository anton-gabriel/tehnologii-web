package utils.repository.specifications;

import database.DatabaseConnection;
import model.User;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CheckUserSpecification extends SqlSpecification<User> {

    public CheckUserSpecification(User entity) {
        super(entity);
    }

    @Override
    public PreparedStatement getSpecification() throws SQLException {
        PreparedStatement statement = DatabaseConnection.getInstance().getConnection()
                .prepareStatement("SELECT username FROM user_account WHERE username = ? lmit 1");
        statement.setString(1, this.entity.getUsername().trim());
        return statement;
    }
}
