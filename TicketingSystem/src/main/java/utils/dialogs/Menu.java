package utils.dialogs;

import javafx.util.Pair;
import model.Ticket;
import model.User;
import utils.commands.UserCommand;
import utils.enums.UserType;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;
import java.util.Scanner;

public class Menu {

    private User user = null;
    private Dialogs dialogs = new Dialogs();
    private UserCommand userCommand;

    public Menu(ObjectInputStream in, ObjectOutputStream out) {
        this.userCommand = new UserCommand(in, out);
    }

    public void loadMenu() {
        Scanner scan = new Scanner(System.in);
        String choice;
        do {
            dialogs.printWelcomeDialog();
            choice = scan.nextLine();
            switch (choice) {
                case "1": {
                    System.out.flush();
                    Pair<String, String> result = dialogs.loginDialog();
                    User user = userCommand.login(result.getKey(), result.getValue());
                    if ((user != null) && (user.getType() == UserType.USER)) {
                        loadUserMenu();
                    } else {
                        loadResolverMenu();
                    }
                }
                break;
                case "2": {
                    System.out.flush();
                    Pair<String, String> result = dialogs.registerDialog();
                    User user = userCommand.register(result.getKey(), result.getValue());
                    if ((user != null) && (user.getType() == UserType.USER)) {
                        loadUserMenu();
                    } else {
                        loadResolverMenu();
                    }
                }
                break;
            }
        } while (!choice.equals("0"));
    }

    private void loadUserMenu() {
        String choice;
        Scanner scan = new Scanner(System.in);
        do {
            dialogs.printUserDialog();
            choice = scan.nextLine();
            switch (choice) {
                case "1":
                    System.out.println("The message for the ticket: ");
                    String message = scan.nextLine();
                    userCommand.createTicket(this.user, message);
                    break;
                case "2":
                    List<Ticket> createdTickets = userCommand.getCreatedTickets(this.user);
                    createdTickets.forEach(System.out::println);
                    break;
            }
        } while (!choice.equals("0"));
    }

    private void loadResolverMenu() {
        String choice;
        Scanner scan = new Scanner(System.in);
        do {
            dialogs.printResolverDialog();
            choice = scan.nextLine();
            switch (choice) {
                case "1":
                    userCommand.getAvailableTickets(this.user);
                    //assign ticket
                    break;
                case "2":
                    userCommand.getResolverTickets(this.user);
                    break;
            }
        } while (!choice.equals("0"));
    }

}
