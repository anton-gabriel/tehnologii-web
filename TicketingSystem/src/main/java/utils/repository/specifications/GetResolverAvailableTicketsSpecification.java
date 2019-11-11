package utils.repository.specifications;

import database.DatabaseConnection;
import model.User;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class GetResolverAvailableTicketsSpecification extends  SqlSpecification<User> {

    public GetResolverAvailableTicketsSpecification(User entity) {
        super(entity);
    }

    @Override
    public PreparedStatement getSpecification() throws SQLException {
        PreparedStatement statement = DatabaseConnection.getInstance().getConnection()
                .prepareStatement("SELECT id, user_id, resolver_id, message, status FROM ticket WHERE resolver_id IS NULL");
        return statement;
    }
}
