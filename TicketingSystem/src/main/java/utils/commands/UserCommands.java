package utils.commands;

import javafx.util.Pair;
import model.Ticket;
import model.User;
import utils.enums.Command;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

public class UserCommands {

    private ObjectInputStream in;
    private ObjectOutputStream out;

    public UserCommands(ObjectInputStream in, ObjectOutputStream out) {
        this.in = in;
        this.out = out;
    }

    public User login(String username, String password) {
        try {
            if (!username.isEmpty() && !password.isEmpty()) {
                out.writeObject(Command.LOGIN);
                User user = new User.UserBuilder(username).setPassword(password).build();
                out.writeObject(user);
                return (User) in.readObject();
            }
            return null;
        } catch (IOException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public User register(String username, String password) {
        try {
            if (!username.isEmpty() && !password.isEmpty()) {
                out.writeObject(Command.REGISTER);
                User user = new User.UserBuilder(username).setPassword(password).build();
                out.writeObject(user);
                return (User) in.readObject();
            }
            return null;
        } catch (IOException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public Boolean createTicket(User user, String message) {
        try {
            Ticket ticket = new Ticket.TicketBuilder(user.getId(), message).build();
            out.writeObject(Command.CREATE_TICKET);
            out.writeObject(ticket);
            return in.readBoolean();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    public Boolean updateTicket(User user, Ticket ticket) {
        try {
            out.writeObject(Command.UPDATE_TICKET);
            out.writeObject(new Pair<User, Ticket>(user, ticket));
            return in.readBoolean();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    public List<Ticket> getAvailableTickets(User user) {
        try {
            out.writeObject(Command.GET_AVAILABLE_TICKETS);
            out.writeObject(user);
            return (List<Ticket>) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public List<Ticket> getCreatedTickets(User user) {
        try {
            out.writeObject(Command.GET_CREATED_TICKETS);
            out.writeObject(user);
            return (List<Ticket>) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public List<Ticket> getResolverTickets(User user) {
        try {
            out.writeObject(Command.GET_RESOLVER_TICKETS);
            out.writeObject(user);
            return (List<Ticket>) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}
