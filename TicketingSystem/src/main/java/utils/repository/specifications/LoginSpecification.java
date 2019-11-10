package utils.repository.specifications;

import database.DatabaseConnection;
import model.User;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class LoginSpecification extends SqlSpecification<User> {

    public LoginSpecification(User entity) {
        super(entity);
    }

    @Override
    public PreparedStatement getSpecification() throws SQLException {
        PreparedStatement statement = DatabaseConnection.getInstance().getConnection()
                .prepareStatement("SELECT id, username, type FROM user_account WHERE username = ? and password =? limit 1");
        statement.setString(1, this.entity.getUsername());
        statement.setString(2, this.entity.getPassword());
        return statement;
    }
}
