package utils.repository.specifications;

import database.DatabaseConnection;
import model.User;
import utils.enums.TicketStatus;

import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * The type Get resolver available tickets specification.
 */
public class GetResolverAvailableTicketsSpecification extends  SqlSpecification<User> {

    /**
     * Instantiates a new Get resolver available tickets specification.
     *
     * @param entity the entity
     */
    public GetResolverAvailableTicketsSpecification(User entity) {
        super(entity);
    }

    @Override
    public PreparedStatement getSpecification() throws SQLException {
        PreparedStatement statement = DatabaseConnection.getInstance().getConnection()
                .prepareStatement("SELECT id, user_id, resolver_id, message, status FROM ticket WHERE resolver_id IS NULL AND status != ?");
        statement.setString(1, TicketStatus.DONE.toString());
        return statement;
    }
}
