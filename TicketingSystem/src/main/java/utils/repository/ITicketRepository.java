package utils.repository;

import model.Ticket;
import model.User;

import java.sql.SQLException;
import java.util.Collection;

/**
 * The interface Ticket repository.
 */
public interface ITicketRepository extends IRepository<Ticket> {
    /**
     * Gets resolver tickets.
     *
     * @param user the user
     * @return the resolver tickets
     * @throws SQLException the sql exception
     */
    Collection<Ticket> getResolverTickets(User user) throws SQLException;

    /**
     * Gets resolver available tickets.
     *
     * @param user the user
     * @return the resolver available tickets
     * @throws SQLException the sql exception
     */
    Collection<Ticket> getResolverAvailableTickets(User user) throws SQLException;

    /**
     * Gets user created tickets.
     *
     * @param user the user
     * @return the user created tickets
     * @throws SQLException the sql exception
     */
    Collection<Ticket> getUserCreatedTickets(User user) throws SQLException;
}
