package client;

import server.Server;
import utils.dialogs.Menu;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 * The type Client.
 */
public class Client {
    private static ObjectInputStream in = null;
    private static ObjectOutputStream out = null;
    private Socket socket = null;

    /**
     * Instantiates a new Client.
     *
     * @throws IOException the io exception
     */
    public Client() throws IOException {
        socket = new Socket("localhost", Server.PORT);
        out = new ObjectOutputStream(socket.getOutputStream());
        in = new ObjectInputStream(socket.getInputStream());
    }

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        try {
            Client client = new Client();
            Menu menu = new Menu(in, out);
            menu.loadMenu();
        } catch (IOException exception) {
            System.out.println(exception.getMessage());
        }
    }
}
