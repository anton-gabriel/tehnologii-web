package utils.dialogs;

import model.Ticket;
import model.User;
import utils.Pair;
import utils.commands.UserCommand;
import utils.enums.TicketStatus;
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
                    if (user != null) {
                        this.user = user;
                        if (this.user.getType() == UserType.USER) {
                            loadUserMenu();
                        } else {
                            loadResolverMenu();
                        }
                    }
                }
                break;
                case "2": {
                    System.out.flush();
                    Pair<String, String> result = dialogs.registerDialog();
                    User user = userCommand.register(result.getKey(), result.getValue());
                    if (user != null) {
                        this.user = user;
                        if (this.user.getType() == UserType.USER) {
                            loadUserMenu();
                        } else {
                            loadResolverMenu();
                        }
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
                    System.out.flush();
                    System.out.println("The message for the ticket: ");
                    String message = scan.nextLine();
                    userCommand.createTicket(this.user, message);
                    break;
                case "2":
                    System.out.flush();
                    List<Ticket> createdTickets = userCommand.getCreatedTickets(this.user);
                    createdTickets.forEach(System.out::println);
                    break;
            }
        } while (!choice.equals("0"));
        this.user = null;
    }

    private void loadResolverMenu() {
        String choice;
        Scanner scan = new Scanner(System.in);
        do {
            dialogs.printResolverDialog();
            choice = scan.nextLine();
            switch (choice) {
                case "1": {
                    List<Ticket> tickets = userCommand.getAvailableTickets(this.user);
                    loadAssignResolverTicketMenu(tickets);
                }
                break;
                case "2": {
                    List<Ticket> tickets = userCommand.getResolverTickets(this.user);
                    loadAssignedResolverTicketMenu(tickets);
                }
                break;
            }
        } while (!choice.equals("0"));
        this.user = null;
    }

    private void loadAssignResolverTicketMenu(List<Ticket> tickets) {
        try {
            Scanner scanner = new Scanner(System.in);
            int choice;
            do {
                System.out.flush();
                tickets.forEach(System.out::println);
                dialogs.printAssignResolverTicketDialog();
                choice = scanner.nextInt();
                userCommand.assignResolverTicket(tickets.get(choice), this.user);
            } while (choice != 0);
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }

    private void loadAssignedResolverTicketMenu(List<Ticket> tickets) {
        try {
            Scanner scanner = new Scanner(System.in);
            int choice;
            TicketStatus status;
            do {
                System.out.flush();
                tickets.forEach(System.out::println);
                dialogs.printAssignedResolverTicketDialog();
                choice = scanner.nextInt();
                System.out.println("Enter desired status.");
                status = TicketStatus.valueOf(scanner.nextLine().trim());
                Ticket ticket = tickets.get(choice);
                ticket.setStatus(status);
                userCommand.updateTicket(ticket);
            } while (choice != 0);
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }
}
