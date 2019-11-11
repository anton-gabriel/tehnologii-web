package utils.dialogs;


import utils.Pair;

import java.util.Scanner;

public class Dialogs {

    private Scanner scanner = new Scanner(System.in);

    public void printWelcomeDialog() {
        System.out.println("1.Login");
        System.out.println("2.Register");
        System.out.println("0.Quit");
    }

    public void printResolverDialog() {
        System.out.println("1.Show unassigned tickets");
        System.out.println("2.See my assigned tickets");
        System.out.println("0.Sign out");
    }

    public void printUserDialog() {
        System.out.println("1.Add new ticket");
        System.out.println("2.View created tickets");
        System.out.println("0.Sign out");
    }

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

    public Pair<String, String> loginDialog() {
        System.out.println("Login: ");
        System.out.println("Username: ");
        String username = scanner.nextLine();
        System.out.println("Password: ");
        String password = scanner.nextLine();
        return new Pair<String, String>(username, password);
    }
}
