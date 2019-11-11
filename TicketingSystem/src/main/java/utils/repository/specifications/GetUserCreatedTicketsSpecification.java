package utils.repository.specifications;

import database.DatabaseConnection;
import model.User;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class GetUserCreatedTicketsSpecification extends  SqlSpecification<User> {

    public GetUserCreatedTicketsSpecification(User entity) {
        super(entity);
    }

    @Override
    public PreparedStatement getSpecification() throws SQLException {
        PreparedStatement statement = DatabaseConnection.getInstance().getConnection()
                .prepareStatement("SELECT id, user_id, resolver_id, message, status FROM ticket WHERE user_id = ?");
        statement.setInt(1, this.entity.getId());
        return statement;
    }
}
