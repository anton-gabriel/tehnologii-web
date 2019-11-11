package utils.commands;

import model.User;
import utils.ServerPool;
import utils.enums.Command;
import utils.repository.TicketRepository;
import utils.repository.UserRepository;

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
                break;
            case UPDATE_TICKET:
                break;
            case GET_AVAILABLE_TICKETS:
                break;
            case GET_CREATED_TICKETS:
                break;
            case GET_RESOLVER_TICKETS:
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
        } catch (IOException | ClassNotFoundException | SQLException exception) {
            System.out.println(exception.getMessage());
        }
    }
}
