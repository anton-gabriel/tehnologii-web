package utils.repository.specifications;

import database.DatabaseConnection;
import model.User;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AddUserSpecification extends SqlSpecification<User> {

    public AddUserSpecification(User entity) {
        super(entity);
    }

    @Override
    public PreparedStatement getSpecification() throws SQLException {
        PreparedStatement statement = DatabaseConnection.getInstance().getConnection()
                .prepareStatement("INSERT INTO user_account(username, password, type) values (?,?,?)");
        statement.setString(1, this.entity.getUsername().trim());
        statement.setString(2, this.entity.getPassword().trim());
        statement.setString(3, this.entity.getType().toString().trim());
        return statement;
    }
}
