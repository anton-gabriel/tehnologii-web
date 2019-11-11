package utils.repository;

import model.Ticket;
import model.User;
import utils.enums.TicketStatus;
import utils.enums.UserType;
import utils.repository.specifications.GetResolverAvailableTicketsSpecification;
import utils.repository.specifications.GetResolverTicketsSpecification;
import utils.repository.specifications.GetUserCreatedTicketsSpecification;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class TicketRepository extends Repository<Ticket> implements ITicketRepository {
    @Override
    public Collection<Ticket> getResolverTickets(User user) throws SQLException {
        if(user.getType() == UserType.RESOLVER) {
            List<Ticket> tickets = new ArrayList<>();
            ResultSet result = new GetResolverTicketsSpecification(user).getSpecification().executeQuery();
            return getTickets(tickets, result);
        }
        return  null;
    }

    @Override
    public Collection<Ticket> getResolverAvailableTickets(User user) throws SQLException {
        if(user.getType() == UserType.RESOLVER) {
            List<Ticket> tickets = new ArrayList<>();
            ResultSet result = new GetResolverAvailableTicketsSpecification(user).getSpecification().executeQuery();
            return getTickets(tickets, result);
        }
        return  null;
    }

    @Override
    public Collection<Ticket> getUserCreatedTickets(User user) throws SQLException {
        if(user.getType() == UserType.USER) {
            List<Ticket> tickets = new ArrayList<>();
            ResultSet result = new GetUserCreatedTicketsSpecification(user).getSpecification().executeQuery();
            return getTickets(tickets, result);
        }
        return  null;
    }

    private Collection<Ticket> getTickets(List<Ticket> tickets, ResultSet result) throws SQLException {
        while (result.next()) {
            int userId = result.getInt("user_id");
            int resolverId = result.getInt("resolver_id");
            String message = result.getString("message").trim();
            TicketStatus status = TicketStatus.valueOf(result.getString("status").trim());
            tickets.add(new Ticket.TicketBuilder(userId, message).setResolverId(resolverId).setStatus(status).build());
        }
        return tickets;
    }
}
