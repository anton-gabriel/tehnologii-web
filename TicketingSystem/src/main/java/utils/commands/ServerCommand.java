package utils.commands;

import model.Ticket;
import model.User;
import utils.ServerPool;
import utils.enums.Command;
import utils.repository.TicketRepositoryBase;
import utils.repository.UserRepositoryBase;
import utils.repository.specifications.AddTicketSpecification;
import utils.repository.specifications.UpdateTicketSpecification;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.SQLException;

/**
 * The type Server command.
 */
public class ServerCommand {

    private ObjectInputStream in;
    private ObjectOutputStream out;

    private UserRepositoryBase userRepository = new UserRepositoryBase();
    private TicketRepositoryBase ticketRepository = new TicketRepositoryBase();

    /**
     * Instantiates a new Server command.
     *
     * @param in  the in
     * @param out the out
     */
    public ServerCommand(ObjectInputStream in, ObjectOutputStream out) {
        this.in = in;
        this.out = out;
    }

    /**
     * Execute the given command.
     *
     * @param command the command
     */
    public void execute(Command command) {
        switch (command) {
            case INVALID:
                break;
            case LOGIN:
                login();
                break;
            case REGISTER:
                register();
                break;
            case CREATE_TICKET:
                createTicket();
                break;
            case UPDATE_TICKET:
                updateTicket();
                break;
            case GET_AVAILABLE_TICKETS:
                getAvailableTickets();
                break;
            case GET_CREATED_TICKETS:
                getCreatedTickets();
                break;
            case GET_RESOLVER_TICKETS:
                getResolverTickets();
                break;
        }
    }

    /**
     *  Gets the login credentials and return the result to the client.
     */
    private void login() {
        try {
            User user = (User) in.readObject();
            if (ServerPool.getInstance().addUser((user))) {
                User result = this.userRepository.login(user);
                out.writeObject(result);
            } else {
                out.writeObject(null);
            }
            out.flush();
        } catch (IOException | ClassNotFoundException | SQLException exception) {
            System.out.println(exception.getMessage());
        }
    }

    /**
     *  Gets the register credentials and return the result to the client.
     */
    private void register() {
        try {
            User user = (User) in.readObject();
            if (ServerPool.getInstance().addUser((user))) {
                User result = this.userRepository.register(user);
                if (result != null) {
                    out.writeObject(this.userRepository.checkUser(user));
                }
            } else {
                out.writeObject(null);
            }
            out.flush();
        } catch (IOException | ClassNotFoundException | SQLException exception) {
            System.out.println(exception.getMessage());
        }
    }

    /**
     *  Gets the ticket data and return the operation result to the client.
     */
    private void createTicket() {
        try {
            Ticket ticket = (Ticket) in.readObject();
            out.writeBoolean(this.ticketRepository.add(new AddTicketSpecification(ticket)) == 1);
            out.flush();
        } catch (IOException | ClassNotFoundException | SQLException exception) {
            System.out.println(exception.getMessage());
        }
    }

    /**
     *  Gets the ticket data and return the operation result to the client.
     */
    private void updateTicket() {
        try {
            Ticket ticket = (Ticket) in.readObject();
            out.writeBoolean(this.ticketRepository.update(new UpdateTicketSpecification(ticket)) == 1);
            out.flush();
        } catch (IOException | ClassNotFoundException | SQLException exception) {
            System.out.println(exception.getMessage());
        }
    }

    /**
     *  Gets the user data and return the available tickets to the client.
     */
    private void getAvailableTickets() {
        try {
            User user = (User) in.readObject();
            out.writeObject(this.ticketRepository.getResolverAvailableTickets(user));
            out.flush();
        } catch (IOException | ClassNotFoundException | SQLException exception) {
            System.out.println(exception.getMessage());
        }
    }

    /**
     *  Gets the user data and return the created tickets to the client.
     */
    private void getCreatedTickets() {
        try {
            User user = (User) in.readObject();
            out.writeObject(this.ticketRepository.getUserCreatedTickets(user));
            out.flush();
        } catch (IOException | ClassNotFoundException | SQLException exception) {
            System.out.println(exception.getMessage());
        }
    }

    /**
     *  Gets the resolver data and return the selected tickets to the client.
     */
    private void getResolverTickets() {
        try {
            User user = (User) in.readObject();
            out.writeObject(this.ticketRepository.getResolverTickets(user));
            out.flush();
        } catch (IOException | ClassNotFoundException | SQLException exception) {
            System.out.println(exception.getMessage());
        }
    }
}
