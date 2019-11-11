package utils.repository.specifications;

import database.DatabaseConnection;
import model.User;
import utils.enums.TicketStatus;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class GetResolverTicketsSpecification extends SqlSpecification<User> {

    public GetResolverTicketsSpecification(User entity) {
        super(entity);
    }

    @Override
    public PreparedStatement getSpecification() throws SQLException {
        PreparedStatement statement = DatabaseConnection.getInstance().getConnection()
                .prepareStatement("SELECT id, user_id, resolver_id, message, status FROM ticket WHERE resolver_id = ? AND status != ?");
        statement.setInt(1, this.entity.getId());
        statement.setString(2, TicketStatus.DONE.toString());
        return statement;
    }
}
