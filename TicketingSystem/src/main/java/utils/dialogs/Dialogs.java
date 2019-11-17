package utils.dialogs;


import utils.Pair;

import java.util.Scanner;

/**
 * The type Dialogs.
 */
public class Dialogs {

    private Scanner scanner = new Scanner(System.in);

    /**
     * Print welcome dialog.
     */
    public void printWelcomeDialog() {
        System.out.println("1.Login");
        System.out.println("2.Register");
        System.out.println("0.Quit");
    }

    /**
     * Print resolver dialog.
     */
    public void printResolverDialog() {
        System.out.println("1.Show unassigned tickets");
        System.out.println("2.See my assigned tickets");
        System.out.println("0.Sign out");
    }

    /**
     * Print user dialog.
     */
    public void printUserDialog() {
        System.out.println("1.Add new ticket");
        System.out.println("2.View created tickets");
        System.out.println("0.Sign out");
    }

    /**
     * Print assign resolver ticket dialog.
     */
    public void printAssignResolverTicketDialog() {
        System.out.println("Select a ticket to assign.");
        System.out.println("0.Cancel");
    }

    /**
     * Print assigned resolver ticket dialog.
     */
    public void printAssignedResolverTicketDialog() {
        System.out.println("Select a ticket to update.");
        System.out.println("0.Cancel");
    }

    /**
     * Register dialog.
     *
     * @return the pair containing the username and password
     */
    public Pair<String, String> registerDialog() {
        System.out.println("Register: ");
        System.out.println("Username: ");
        String username = scanner.nextLine();
        System.out.println("Password: ");
        String password = scanner.nextLine();
        System.out.println("Repeat password: ");
        String repeatedPassword = scanner.nextLine();
        return password.equals(repeatedPassword) ?
                new Pair<String, String>(username, password) : null;
    }

    /**
     * Login dialog.
     *
     * @return the pair containing the username and password
     */
    public Pair<String, String> loginDialog() {
        System.out.println("Login: ");
        System.out.println("Username: ");
        String username = scanner.nextLine();
        System.out.println("Password: ");
        String password = scanner.nextLine();
        return new Pair<String, String>(username, password);
    }
}
