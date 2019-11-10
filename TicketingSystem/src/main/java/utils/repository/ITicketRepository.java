package utils.repository;

import model.Ticket;
import model.User;

import java.sql.SQLException;
import java.util.Collection;

public interface ITicketRepository extends IRepository<Ticket> {
    Collection<Ticket> getResolverTickets(User user) throws SQLException;

    Collection<Ticket> getResolverAvailableTickets(User user) throws SQLException;

    Collection<Ticket> getUserCreatedTickets(User user) throws SQLException;
}
