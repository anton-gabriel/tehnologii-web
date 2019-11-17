package utils.commands;

import model.Ticket;
import model.User;
import utils.enums.Command;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

/**
 * The type User command.
 */
public class UserCommand {

    private ObjectInputStream in;
    private ObjectOutputStream out;

    /**
     * Instantiates a new User command.
     *
     * @param in  the in
     * @param out the out
     */
    public UserCommand(ObjectInputStream in, ObjectOutputStream out) {
        this.in = in;
        this.out = out;
    }

    /**
     * Login user.
     *
     * @param username the username
     * @param password the password
     * @return the user
     */
    public User login(String username, String password) {
        try {
            if (!username.isEmpty() && !password.isEmpty()) {
                out.writeObject(Command.LOGIN);
                User user = new User.UserBuilder(username).setPassword(password).build();
                out.writeObject(user);
                out.flush();
                return (User) in.readObject();
            }
            return null;
        } catch (IOException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    /**
     * Register user.
     *
     * @param username the username
     * @param password the password
     * @return the user
     */
    public User register(String username, String password) {
        try {
            if (!username.isEmpty() && !password.isEmpty()) {
                out.writeObject(Command.REGISTER);
                User user = new User.UserBuilder(username).setPassword(password).build();
                out.writeObject(user);
                out.flush();
                return (User) in.readObject();
            }
            return null;
        } catch (IOException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    /**
     * Create ticket.
     *
     * @param user    the user
     * @param message the message
     * @return the boolean
     */
    public Boolean createTicket(User user, String message) {
        try {
            Ticket ticket = new Ticket.TicketBuilder(user.getId(), message).build();
            out.writeObject(Command.CREATE_TICKET);
            out.writeObject(ticket);
            out.flush();
            return in.readBoolean();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    /**
     * Assign resolver ticket.
     *
     * @param ticket   the ticket
     * @param resolver the resolver
     * @return the boolean
     */
    public Boolean assignResolverTicket(Ticket ticket, User resolver) {
        try {
            ticket.setResolverId(resolver.getId());
            out.writeObject(Command.UPDATE_TICKET);
            out.writeObject(ticket);
            out.flush();
            return in.readBoolean();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    /**
     * Update ticket.
     *
     * @param ticket the ticket
     * @return the boolean
     */
    public Boolean updateTicket(Ticket ticket) {
        try {
            out.writeObject(Command.UPDATE_TICKET);
            out.writeObject(ticket);
            out.flush();
            return in.readBoolean();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    /**
     * Gets available tickets.
     *
     * @param user the user
     * @return the available tickets
     */
    public List<Ticket> getAvailableTickets(User user) {
        try {
            out.writeObject(Command.GET_AVAILABLE_TICKETS);
            out.writeObject(user);
            out.flush();
            return (List<Ticket>) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    /**
     * Gets created tickets.
     *
     * @param user the user
     * @return the created tickets
     */
    public List<Ticket> getCreatedTickets(User user) {
        try {
            out.writeObject(Command.GET_CREATED_TICKETS);
            out.writeObject(user);
            out.flush();
            return (List<Ticket>) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    /**
     * Gets resolver tickets.
     *
     * @param user the user
     * @return the resolver tickets
     */
    public List<Ticket> getResolverTickets(User user) {
        try {
            out.writeObject(Command.GET_RESOLVER_TICKETS);
            out.writeObject(user);
            out.flush();
            return (List<Ticket>) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}
