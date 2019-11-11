package utils.commands;

import model.Ticket;
import model.User;
import utils.ServerPool;
import utils.enums.Command;
import utils.repository.TicketRepository;
import utils.repository.UserRepository;
import utils.repository.specifications.AddTicketSpecification;
import utils.repository.specifications.UpdateTicketSpecification;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.SQLException;

public class ServerCommand {

    private ObjectInputStream in;
    private ObjectOutputStream out;

    private UserRepository userRepository = new UserRepository();
    private TicketRepository ticketRepository = new TicketRepository();
    private ServerPool serverPool = new ServerPool();

    public ServerCommand(ObjectInputStream in, ObjectOutputStream out) {
        this.in = in;
        this.out = out;
    }

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

    private void login() {
        try {
            User user = (User) in.readObject();
            if (this.serverPool.addUser((user))) {
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

    private void register() {
        try {
            User user = (User) in.readObject();
            if (this.serverPool.addUser((user))) {
                User result = this.userRepository.register(user);
                out.writeObject(result);
            } else {
                out.writeObject(null);
            }
            out.flush();
        } catch (IOException | ClassNotFoundException | SQLException exception) {
            System.out.println(exception.getMessage());
        }
    }

    private void createTicket() {
        try {
            Ticket ticket = (Ticket) in.readObject();
            out.writeBoolean(this.ticketRepository.add(new AddTicketSpecification(ticket)) == 1);
            out.flush();
        } catch (IOException | ClassNotFoundException | SQLException exception) {
            System.out.println(exception.getMessage());
        }
    }

    private void updateTicket() {
        try {
            Ticket ticket = (Ticket) in.readObject();
            out.writeBoolean(this.ticketRepository.update(new UpdateTicketSpecification(ticket)) == 1);
            out.flush();
        } catch (IOException | ClassNotFoundException | SQLException exception) {
            System.out.println(exception.getMessage());
        }
    }

    private void getAvailableTickets() {
        try {
            User user = (User) in.readObject();
            out.writeObject(this.ticketRepository.getResolverAvailableTickets(user));
            out.flush();
        } catch (IOException | ClassNotFoundException | SQLException exception) {
            System.out.println(exception.getMessage());
        }
    }

    private void getCreatedTickets() {
        try {
            User user = (User) in.readObject();
            out.writeObject(this.ticketRepository.getUserCreatedTickets(user));
            out.flush();
        } catch (IOException | ClassNotFoundException | SQLException exception) {
            System.out.println(exception.getMessage());
        }
    }

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
