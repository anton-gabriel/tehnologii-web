package client;

import database.DatabaseConnection;
import model.User;
import org.w3c.dom.CDATASection;
import server.Server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.sql.SQLException;
import java.util.List;

public class Client {
    private static ObjectInputStream in = null;
    private static ObjectOutputStream out = null;
    private Socket socket = null;

    public Client() {
        try {
            socket = new Socket("localhost", Server.PORT);
            out = new ObjectOutputStream(socket.getOutputStream());
            in = new ObjectInputStream(socket.getInputStream());

        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * execute login Request
     */
    public static String doLogin(String username, String password, String command) throws ClassNotFoundException, IOException {
        out.writeObject(command);
        if (!username.isEmpty() && !password.isEmpty()) {
            try {
                out.writeObject(username);
                out.writeObject(password);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public static String doRegister(String username, String password, String command) throws ClassNotFoundException, IOException {
        out.writeObject(command);
        if (!username.isEmpty() && !password.isEmpty()) {
            try {
                out.writeObject(username);
                out.writeObject(password);
                // se citeste 1 in caz ca utilizatorul s-a inregistrat cu succes
                int registerUser =  in.readInt();
                System.out.println("Utilizatorul inregistrat este : "+ registerUser);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }


    public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException {
        DatabaseConnection connectionDB = DatabaseConnection.getInstance();
        List<User> userList = connectionDB.getAccounts();
        System.out.println("Utilizatorii"+ userList.toString());
        Client client = new Client();
//        doLogin(userList.get(0).getUsername(), userList.get(0).getPassword(),"login");
        doRegister("vlad2", "assasa","register");

        while (true) {
            try {


            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
}
